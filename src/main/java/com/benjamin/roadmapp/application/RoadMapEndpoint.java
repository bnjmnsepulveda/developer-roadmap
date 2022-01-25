package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapKnowledgeUpdatedDTO;
import com.benjamin.roadmapp.application.dto.RoadMapLanguageUpdatedDTO;

import java.util.List;

public interface RoadMapEndpoint {

    RoadMapDTO create(CreateRoadMapDTO roadMap);
    List<RoadMapDTO> findAll();
    RoadMapKnowledgeUpdatedDTO updateKnowledge(String id, List<String> knowledgeIds);
    RoadMapLanguageUpdatedDTO updateLanguage(String id, List<String> languageIds);

}
