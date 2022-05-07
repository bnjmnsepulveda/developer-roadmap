package com.benjamin.roadmapp.infraestructure.neo4j.model;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@ToString
@Node("Language")
public class LanguageNode {
    @Id
    private String id;
    @Property
    private String name;
    @Property
    private List<String> properties;
   /* @Relationship(type = "LANGUAGE_TO_DOMAIN", direction = Relationship.Direction.INCOMING)
    private RoadMapNode roadMap;*/

    public static LanguageNode map(Language e){
        return LanguageNode.builder()
                .id(e.getId())
                .name(e.getName())
                .properties(e.getProperties())
                .build();
    }

    public static List<LanguageNode> map(List<Language> entities) {
        return entities
                .stream()
                .map(LanguageNode::map)
                .collect(Collectors.toList());
    }

    @Deprecated
    public static Language toEntity(LanguageNode n){
        return Language.builder()
                .id(n.getId())
                .name(n.getName())
                .properties(n.getProperties())
                .build();
    }
}
