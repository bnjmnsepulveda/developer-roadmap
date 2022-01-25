package com.benjamin.roadmapp.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoadMapKnowledgeUpdatedDTO {
    private String id;
    private String roadMapName;
    private List<KnowledgeDTO> knowledge;
}
