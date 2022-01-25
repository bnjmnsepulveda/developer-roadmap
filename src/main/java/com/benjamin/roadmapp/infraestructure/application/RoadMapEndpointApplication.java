package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.RoadMapEndpoint;
import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RoadMapEndpointApplication implements RoadMapEndpoint {

    @Autowired
    private RoadMapService service;

    @Override
    public RoadMapDTO create(CreateRoadMapDTO createRoadMapDTO) {
        var id = UUID.randomUUID().toString();
        var newRoadmap = RoadMap.builder()
                .id(id)
                .name(createRoadMapDTO.getName())
                .description(createRoadMapDTO.getDescription())
                .build();
        var entity = service.create(newRoadmap);
        return RoadMapDTO.map(entity);
    }

    @Override
    public List<RoadMapDTO> findAll() {
        return service.findAll()
                .stream()
                .map(RoadMapDTO::map)
                .collect(Collectors.toList());
    }

    @Override
    public void updateKnowledge(String id, List<String> knowledgeIds) {
        var entityFound = service.findById(id);


    }

    @Override
    public void updateLanguage(String id, List<String> languageIds) {

    }

}
