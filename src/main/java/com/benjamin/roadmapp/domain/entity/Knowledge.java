package com.benjamin.roadmapp.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Knowledge {

    private String name;
    private List<Knowledge> nextKnowledgeToLearn;

}
