package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.KnowledgeDTO;

import java.util.List;

public interface FindKnowledge {

    List<KnowledgeDTO> findAll();
}
