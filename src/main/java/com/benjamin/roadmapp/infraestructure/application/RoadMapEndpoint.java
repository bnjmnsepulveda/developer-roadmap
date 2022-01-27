package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.AddRoadMap;
import com.benjamin.roadmapp.application.FindRoadMap;
import com.benjamin.roadmapp.application.UpdateRoadMapKnowledge;
import com.benjamin.roadmapp.application.UpdateRoadMapLanguage;
import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapKnowledgeUpdatedDTO;
import com.benjamin.roadmapp.application.dto.RoadMapLanguageUpdatedDTO;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class RoadMapEndpoint implements AddRoadMap, FindRoadMap, UpdateRoadMapKnowledge, UpdateRoadMapLanguage {

    @Autowired
    private RoadMapService roadMapService;
    @Autowired
    private KnowledgeService knowledgeService;
    @Autowired
    private LanguageService languageService;
    @Autowired
    private GenerateUniqueID generateUniqueID;

    @Override
    public RoadMapDTO create(CreateRoadMapDTO createRoadMapDTO) {
        var id = generateUniqueID.handle();
        var newRoadmap = RoadMap.builder()
                .id(id)
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
    public RoadMapKnowledgeUpdatedDTO updateKnowledge(String id, List<String> knowledgeIds) {
        var entityFound = roadMapService.findById(id);
        entityFound.setKnowledgeToDomain(knowledgeService.findByIds(knowledgeIds));
        var entityUpdated = roadMapService.update(entityFound);
        return RoadMapKnowledgeUpdatedDTO
                .builder()
                .id(entityUpdated.getId())
                .roadMapName(entityUpdated.getName())
                .knowledge(RoadMapDTO.mapToKnowledge(entityUpdated.getKnowledgeToDomain()))
                .build();
    }

    @Override
    public RoadMapLanguageUpdatedDTO updateLanguage(String id, List<String> languageIds) {
        var entityFound = roadMapService.findById(id);
        entityFound.setLanguagesToDomain(languageService.findByIds(languageIds));
        var entityUpdated = roadMapService.update(entityFound);
        return RoadMapLanguageUpdatedDTO
                .builder()
                .id(entityUpdated.getId())
                .roadMapName(entityUpdated.getName())
                .languages(RoadMapDTO.mapToLanguages(entityUpdated.getLanguagesToDomain()))
                .build();
    }
}
