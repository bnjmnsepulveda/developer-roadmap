package com.benjamin.roadmapp.infraestructure.neo4j.repository;

import com.benjamin.roadmapp.infraestructure.neo4j.model.RoadMapNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface RoadMapNeo4jRepository extends Neo4jRepository<RoadMapNode, String> {
}
