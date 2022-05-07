package com.benjamin.roadmapp.application.api;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.application.dto.RoadMapDTO;

public interface AddRoadMap {
    RoadMapDTO create(CreateRoadMapDTO createRoadMapDTO);
}
