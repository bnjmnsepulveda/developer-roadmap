package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.RoadMap;

import java.util.List;

public interface RoadMapService {

    void create(RoadMap roadMap);
    List<RoadMap> findAll();
    void update(RoadMap roadMap);

}
