package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.model.LanguageNode;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.LanguageNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class LanguageNeo4jService implements LanguageRepository {

    @Autowired
    private LanguageNeo4jRepository repository;

    @Override
    public Language save(Language language) {
        var newNode = LanguageNode.map(language);
        var createdNode = repository.save(newNode);
        language.setId(createdNode.getId());
        return language;
    }

    @Override
    public Optional<Language> findById(String id) {
        return repository
                .findById(id)
                .map(LanguageNode::toEntity);
    }

    @Override
    public List<Language> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LanguageNode::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Language> findByIds(List<String> ids) {
        return repository.findAll()
                .stream()
                .filter(l -> ids.contains(l.getId()))
                .map(LanguageNode::toEntity)
                .collect(Collectors.toList());
    }
}
