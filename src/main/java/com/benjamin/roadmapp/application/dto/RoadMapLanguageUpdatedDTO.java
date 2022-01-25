package com.benjamin.roadmapp.application.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoadMapLanguageUpdatedDTO {
    private String id;
    private String roadMapName;
    private List<LanguageDTO> languages;
}
