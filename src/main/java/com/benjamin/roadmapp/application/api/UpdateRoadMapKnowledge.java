package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.RoadMapKnowledgeUpdatedDTO;

import java.util.List;

public interface UpdateRoadMapKnowledge {

    RoadMapKnowledgeUpdatedDTO updateKnowledge(String id, List<String> knowledgeIds);

}
