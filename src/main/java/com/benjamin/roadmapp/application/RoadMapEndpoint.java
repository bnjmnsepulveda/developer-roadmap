package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;

import java.util.List;

public interface RoadMapEndpoint {

    RoadMapDTO create(CreateRoadMapDTO roadMap);
    List<RoadMapDTO> findAll();
    void updateKnowledge(String id, List<String> knowledgeIds);
    void updateLanguage(String id, List<String> languageIds);

}
