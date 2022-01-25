package com.benjamin.roadmapp.infraestructure.domain.service;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.infraestructure.exception.EntityNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpringKnowledgeService implements KnowledgeService {

    private Map<String, Knowledge> data = new HashMap<>();

    @Override
    public Knowledge create(Knowledge knowledge) {
        return data.put(knowledge.getId(), knowledge);
    }

    @Override
    public Knowledge findById(String id) {
        var entityFound = data.get(id);
        if (entityFound == null) {
            throw new EntityNotFound("Knowledge(id='" + id + "') not found");
        }
        return entityFound;
    }

    @Override
    public List<Knowledge> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public List<Knowledge> findByIds(List<String> ids) {
        return data
                .values()
                .stream()
                .filter(knowledge -> ids.contains(knowledge.getId()))
                .collect(Collectors.toList());
    }
}
