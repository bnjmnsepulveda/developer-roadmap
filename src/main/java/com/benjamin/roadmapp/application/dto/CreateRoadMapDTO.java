package com.benjamin.roadmapp.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRoadMapDTO {
    private String name;
    private String description;
}
