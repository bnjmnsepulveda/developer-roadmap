package com.benjamin.roadmapp.application;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;

import java.util.List;

public interface RoadMapEndpoint {

    void create(CreateRoadMapDTO roadMap);
    List<RoadMapDTO> findAll();
    void updateKnowledge(List<String> knowledgeIds);
    void updateLanguage(List<String> languageIds);

}
