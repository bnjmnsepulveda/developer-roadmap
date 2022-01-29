package com.benjamin.roadmapp.infraestructure.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface KnowledgeNodeRepository extends Neo4jRepository<KnowledgeNode, String> {

    KnowledgeNode findByName(String name);

}
