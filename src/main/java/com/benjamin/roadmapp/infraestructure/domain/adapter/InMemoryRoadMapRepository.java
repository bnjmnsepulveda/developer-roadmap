package com.benjamin.roadmapp.infraestructure.domain.adapter;

import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.ports.outgoing.RoadMapRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Repository
public class InMemoryRoadMapRepository implements RoadMapRepository {

    private Map<String, RoadMap> data = new ConcurrentHashMap<>();

    @Override
    public RoadMap save(RoadMap roadMap) {
        return data.put(roadMap.getId(), roadMap);
    }

    @Override
    public Optional<RoadMap> findById(String id) {
        return Optional.of(data.get(id));
    }

    @Override
    public Stream<RoadMap> findAll() {
        return data.values().stream();
    }
}
