package com.benjamin.roadmapp.domain.ports.outgoing;

import com.benjamin.roadmapp.domain.entity.Knowledge;

import java.util.List;
import java.util.Optional;

public interface KnowledgeRepository {

    Knowledge save(Knowledge knowledge);
    Optional<Knowledge> findById(String id);
    List<Knowledge> findAll();

}
