package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.ports.incoming.DomainService;
import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import com.benjamin.roadmapp.domain.exception.EntityNotFound;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class KnowledgeService implements DomainService<Knowledge> {

    private KnowledgeRepository repository;

    @Override
    public Knowledge create(Knowledge knowledge) {
        return repository.save(knowledge);
    }

    @Override
    public Knowledge findById(String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFound("Knowledge(id='" + id + "') not found"));
    }

    @Override
    public List<Knowledge> findAll() {
        return repository.findAll();
    }

    public List<Knowledge> findByIds(List<String> ids) {
        return repository
                .findAll()
                .stream()
                .filter(knowledge -> ids.contains(knowledge.getId()))
                .collect(Collectors.toList());
    }

}
