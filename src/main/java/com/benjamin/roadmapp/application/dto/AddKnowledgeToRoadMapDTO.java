package com.benjamin.roadmapp.application.dto;

import com.benjamin.roadmapp.domain.enumerate.LearningPriority;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Builder
@ToString
public class AddKnowledgeToRoadMapDTO {
    private String roadMapId;
    private String knowledgeId;
    private List<String> learningGoals;
    private LearningPriority priority;
}
