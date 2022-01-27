package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryKnowledgeRepository implements KnowledgeRepository {

    private Map<String, Knowledge> data = new HashMap<>();

    @Autowired
    private KnowledgeRepository repository;

    @Override
    public Knowledge save(Knowledge knowledge) {
        return data.put(knowledge.getId(), knowledge);
    }

    @Override
    public Optional<Knowledge> findById(String id) {
        return Optional.of(data.get(id));
    }

    @Override
    public List<Knowledge> findAll() {
        return new ArrayList<>(data.values());
    }


}