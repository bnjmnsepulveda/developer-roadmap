package com.benjamin.roadmapp.infraestructure.neo4j.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

import java.util.List;

@Data
@Builder
@ToString
@Node("Language")
public class LanguageNode {
    @Id
    private String name;
    @Property
    private List<String> properties;
}
