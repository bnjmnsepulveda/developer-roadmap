package com.benjamin.roadmapp.application.dto;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class KnowledgeDTO {

    private String id;
    private String name;

    public static KnowledgeDTO map(Knowledge entity){
        return KnowledgeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
