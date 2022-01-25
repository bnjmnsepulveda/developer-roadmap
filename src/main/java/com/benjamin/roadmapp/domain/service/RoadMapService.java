package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.RoadMap;

import java.util.List;

public interface RoadMapService {

    RoadMap create(RoadMap roadMap);
    RoadMap findById(String id);
    List<RoadMap> findAll();
    void update(RoadMap roadMap);

}
