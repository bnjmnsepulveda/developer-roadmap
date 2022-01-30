package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.KnowledgeNode;
import com.benjamin.roadmapp.infraestructure.neo4j.KnowledgeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class Neo4jKnowledgeRepository implements KnowledgeRepository {

    @Autowired
    private KnowledgeNodeRepository repository;

    @Override
    public Knowledge save(Knowledge knowledge) {
        var newKnowledge = KnowledgeNode.map(knowledge);
        var knowledgeCreated = repository.save(newKnowledge);
        return KnowledgeNode.toEntity(knowledgeCreated);
    }

    @Override
    public Optional<Knowledge> findById(String id) {
        return repository
                .findById(id)
                .map(KnowledgeNode::toEntity);
    }

    @Override
    public List<Knowledge> findAll() {
        return null;
    }
}
