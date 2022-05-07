package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.NextToLearn;
import com.benjamin.roadmapp.domain.ports.incoming.NextToLearnService;
import com.benjamin.roadmapp.infraestructure.neo4j.model.KnowledgeNode;
import com.benjamin.roadmapp.infraestructure.neo4j.model.NextToLearnRelationship;
import com.benjamin.roadmapp.infraestructure.neo4j.model.RoadMapNode;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.RoadMapNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NextToLearnNeo4jService implements NextToLearnService {

    @Autowired
    private RoadMapNeo4jRepository roadmapRepository;

    @Override
    public boolean create(NextToLearn entity) {
        var node = RoadMapNode.map(entity.getRoadMap());
        var newRelationship = NextToLearnRelationship.builder()
                .knowledgeNode(KnowledgeNode.map(entity.getKnowledge()))
                .learningGoals(entity.getLearningGoals())
                .priority(entity.getPriority())
                .build();
        var relationships = node.getKnowledgeToLearn();
        if (relationships == null) {
            relationships = new ArrayList<>();
        }
        relationships.add(newRelationship);
        node.setKnowledgeToLearn(relationships);
        roadmapRepository.save(node);
        return true;
    }
}
