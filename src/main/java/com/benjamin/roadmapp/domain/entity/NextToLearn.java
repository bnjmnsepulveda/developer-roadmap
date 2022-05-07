package com.benjamin.roadmapp.domain.entity;

import com.benjamin.roadmapp.domain.enumerate.LearningPriority;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NextToLearn {

    private RoadMap roadMap;
    private Knowledge knowledge;
    private List<String> learningGoals;
    private LearningPriority priority;

}
