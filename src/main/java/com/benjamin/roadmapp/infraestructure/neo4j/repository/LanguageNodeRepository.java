package com.benjamin.roadmapp.infraestructure.neo4j.repository;


import com.benjamin.roadmapp.infraestructure.neo4j.model.LanguageNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LanguageNodeRepository extends Neo4jRepository<LanguageNode, String> {
}
