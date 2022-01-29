package com.benjamin.roadmapp.infraestructure.neo4j;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@Builder
@ToString
@Node("Roadmap")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RoadMapNode {

    @Id
    @EqualsAndHashCode.Include
    private String name;
    @Property
    private String description;
    @Relationship(type = "KNOWLEDGE_TO_LEARN")
    private List<KnowledgeNode> knowledgeToLearn;
    @Relationship(type = "LANGUAGE_TO_DOMAIN")
    private List<LanguageNode> languagesToDomain;

}
