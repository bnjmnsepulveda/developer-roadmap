package com.benjamin.roadmapp.infraestructure.application.api.service;

import com.benjamin.roadmapp.application.api.*;
import com.benjamin.roadmapp.application.dto.*;
import com.benjamin.roadmapp.domain.entity.NextToLearn;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.ports.incoming.NextToLearnService;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class RoadmapEndpointService implements AddRoadMap, FindRoadMap, UpdateRoadmapLanguages, UpdateRoadmapKnowledge {

    @Autowired
    private RoadMapService roadMapService;
    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private GenerateUniqueID generateUniqueID;
    @Autowired
    private NextToLearnService nextToLearnService;

    @Override
    public RoadMapDTO create(CreateRoadMapDTO createRoadMapDTO) {
        var newRoadmap = RoadMap.builder()
                .id(generateUniqueID.handle())
                .name(createRoadMapDTO.getName())
                .description(createRoadMapDTO.getDescription())
                .build();
        var entity = roadMapService.create(newRoadmap);
        return RoadMapDTO.map(entity);
    }

    @Override
    public List<RoadMapDTO> findAll() {
        return roadMapService.findAll()
                .stream()
                .map(RoadMapDTO::map)
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateLanguages(String id, List<String> languageIds) {

        var roadmap = roadMapService.findById(id);
        var languagesToUpdate = languageService.findByIds(languageIds);
        roadmap.setLanguagesToDomain(languagesToUpdate);

        roadMapService.update(roadmap);
        return true;

    }

    @Override
    public boolean addKnowledge(AddKnowledgeToRoadMapDTO request) {
        var roadmap = roadMapService.findById(request.getRoadMapId());
        var knowledge = knowledgeService.findById(request.getKnowledgeId());
        var nextToLearn = NextToLearn.builder()
                .knowledge(knowledge)
                .roadMap(roadmap)
                .learningGoals(request.getLearningGoals())
                .priority(request.getPriority())
                .build();
        return nextToLearnService.create(nextToLearn);
    }
}
