package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateKnowledgeDTO;
import com.benjamin.roadmapp.application.dto.KnowledgeDTO;

public interface AddKnowledge {

    KnowledgeDTO create(CreateKnowledgeDTO createKnowledgeDTO);
}
