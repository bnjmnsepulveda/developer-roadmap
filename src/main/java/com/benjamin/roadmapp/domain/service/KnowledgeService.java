package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.Knowledge;

import java.util.List;

public interface KnowledgeService {

    Knowledge create(Knowledge knowledge);
    Knowledge findById(String id);
    List<Knowledge> findAll();

}
