package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.model.KnowledgeNode;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.KnowledgeNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class KnowledgeNeo4jService implements KnowledgeRepository {

    @Autowired
    private KnowledgeNeo4jRepository repository;

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
        return repository
                .findAll()
                .stream()
                .map(KnowledgeNode::toEntity)
                .collect(Collectors.toList());
    }
}
