package com.benjamin.roadmapp.domain.service;

import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.exception.RoadMapNotFoundException;
import com.benjamin.roadmapp.domain.ports.incoming.DomainService;
import com.benjamin.roadmapp.domain.ports.outgoing.RoadMapRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RoadMapService implements DomainService<RoadMap> {

    private RoadMapRepository repository;

    @Override
    public RoadMap create(RoadMap roadMap) {
        return repository.save(roadMap);
    }

    @Override
    public RoadMap findById(String id) {
       return repository
               .findById(id)
               .orElseThrow(() -> new RoadMapNotFoundException(id));
    }

    @Override
    public List<RoadMap> findAll() {
        return repository
                .findAll()
                .collect(Collectors.toList());
    }

    public RoadMap update(RoadMap roadMap) {
        return repository.save(roadMap);
    }
}
