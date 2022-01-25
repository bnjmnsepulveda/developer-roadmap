package com.benjamin.roadmapp.application.dto;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RoadMapDTO {

    private String id;
    private String name;
    private String description;
    private List<LanguageDTO> languagesToDomain;
    private List<KnowledgeDTO> knowledgeToDomain;

    public static RoadMapDTO map(RoadMap e) {
        return RoadMapDTO.builder()
                .id(e.getId())
                .description(e.getDescription())
                .name(e.getName())
                .knowledgeToDomain(mapToKnowledge(e.getKnowledgeToDomain()))
                .languagesToDomain(mapToLanguages(e.getLanguagesToDomain()))
                .build();
    }

    protected static List<KnowledgeDTO> mapToKnowledge(List<Knowledge> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
                .map(KnowledgeDTO::map)
                .collect(Collectors.toList());
    }

    protected static List<LanguageDTO> mapToLanguages(List<Language> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        return list.stream()
                .map(LanguageDTO::map)
                .collect(Collectors.toList());
    }


}
