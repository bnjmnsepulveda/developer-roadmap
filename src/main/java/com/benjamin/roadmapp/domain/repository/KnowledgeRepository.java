package com.benjamin.roadmapp.domain.repository;

import com.benjamin.roadmapp.domain.entity.Knowledge;

public interface KnowledgeRepository {

    void save(Knowledge knowledge);
    Knowledge findById(String id);

}
