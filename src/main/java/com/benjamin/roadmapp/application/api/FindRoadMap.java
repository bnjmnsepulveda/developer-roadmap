package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.RoadMapDTO;

import java.util.List;

public interface FindRoadMap {

    List<RoadMapDTO> findAll();
}
