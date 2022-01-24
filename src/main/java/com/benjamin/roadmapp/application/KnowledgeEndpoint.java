package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;

import java.util.List;

public interface KnowledgeEndpoint {

    KnowledgeDTO create(CreateKnowledgeDTO createKnowledge);
    List<KnowledgeDTO> findAll();

}
