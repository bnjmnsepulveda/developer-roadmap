package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.ports.outgoing.RoadMapRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.lib.EntityMapper;
import com.benjamin.roadmapp.infraestructure.neo4j.model.LanguageNode;
import com.benjamin.roadmapp.infraestructure.neo4j.model.RoadMapNode;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.LanguageNeo4jRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.RoadMapNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class RoadMapNeo4jService implements RoadMapRepository {

    @Autowired
    private RoadMapNeo4jRepository roadmapRepository;
    @Autowired
    private LanguageNeo4jRepository languageNeo4jRepository;
    @Autowired
    private EntityMapper entityMapper;

    @Override
    public RoadMap save(RoadMap roadMap) {
        var newRoadmapNode = RoadMapNode.map(roadMap);
        if (roadMap.getLanguagesToDomain() != null) {
            var newLanguagesNode = LanguageNode.map(roadMap.getLanguagesToDomain());
            newRoadmapNode.setLanguagesToDomain(newLanguagesNode);
        }
        var createdRoadmap = roadmapRepository.save(newRoadmapNode);
        return entityMapper.map(createdRoadmap);
    }

    @Override
    public Optional<RoadMap> findById(String id) {
        return roadmapRepository
                .findById(id)
                .map(entityMapper::map);
    }

    @Override
    public Stream<RoadMap> findAll() {
        return roadmapRepository
                .findAll()
                .stream()
                .map(entityMapper::map);
    }


}
