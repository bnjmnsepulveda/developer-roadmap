package com.benjamin.roadmapp.infraestructure.neo4j.model;

import com.benjamin.roadmapp.domain.entity.RoadMap;
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
    private String id;
    @Property
    private String name;
    @Property
    private String description;
    @Relationship(type = "KNOWLEDGE_TO_LEARN")
    private List<NextToLearnRelationship> knowledgeToLearn;
    @Relationship(type = "LANGUAGE_TO_DOMAIN", direction = Relationship.Direction.OUTGOING)
    private List<LanguageNode> languagesToDomain;

    public static RoadMapNode map(RoadMap e) {
        return RoadMapNode.builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .build();
    }

}
