package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.AddKnowledgeToRoadMapDTO;

import java.util.List;

public interface UpdateRoadmapKnowledge {

   boolean addKnowledge(AddKnowledgeToRoadMapDTO request);

}
