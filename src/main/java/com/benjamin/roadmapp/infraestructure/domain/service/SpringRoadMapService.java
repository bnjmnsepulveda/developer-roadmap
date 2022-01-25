package com.benjamin.roadmapp.infraestructure.domain.service;

import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import com.benjamin.roadmapp.infraestructure.exception.EntityNotFound;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SpringRoadMapService implements RoadMapService {

    private Map<String,RoadMap> data = new HashMap<>();

    @Override
    public RoadMap create(RoadMap roadMap) {
        return data.put(roadMap.getId(), roadMap);
    }

    @Override
    public RoadMap findById(String id) {
        var entityFound = data.get(id);
        if (entityFound == null) {
            throw new EntityNotFound("RoadMap(id='" + id + "') not found");
        }
        return entityFound;
    }

    @Override
    public List<RoadMap> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public RoadMap update(RoadMap roadMap) {
        return data.replace(roadMap.getId(), roadMap);
    }
}
