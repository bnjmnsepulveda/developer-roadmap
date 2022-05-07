package com.benjamin.roadmapp.infraestructure.neo4j.lib;

import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.infraestructure.neo4j.model.LanguageNode;
import com.benjamin.roadmapp.infraestructure.neo4j.model.RoadMapNode;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityMapper {

    public RoadMap map(RoadMapNode n) {

        var entity = RoadMap.builder()
                .id(n.getId())
                .name(n.getName())
                .description(n.getDescription())
                .build();
        if (n.getLanguagesToDomain() != null) {
            var languages = n
                    .getLanguagesToDomain()
                    .stream()
                    .map(this::map)
                    .collect(Collectors.toList());
            entity.setLanguagesToDomain(languages);
        }
        return entity;
    }

    public Language map(LanguageNode n) {
        return Language.builder()
                .id(n.getId())
                .name(n.getName())
                .properties(n.getProperties())
                .build();
    }

}
