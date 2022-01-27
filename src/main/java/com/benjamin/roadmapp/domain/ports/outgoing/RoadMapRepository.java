package com.benjamin.roadmapp.domain.ports.outgoing;

import com.benjamin.roadmapp.domain.entity.RoadMap;

import java.util.Optional;
import java.util.stream.Stream;

public interface RoadMapRepository {

    RoadMap save(RoadMap roadMap);
    Optional<RoadMap> findById(String id);
    Stream<RoadMap> findAll();

}
