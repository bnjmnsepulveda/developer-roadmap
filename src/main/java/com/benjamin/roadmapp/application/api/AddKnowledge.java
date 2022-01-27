package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;

public interface AddKnowledge {

    KnowledgeDTO create(CreateKnowledgeDTO createKnowledgeDTO);
}
