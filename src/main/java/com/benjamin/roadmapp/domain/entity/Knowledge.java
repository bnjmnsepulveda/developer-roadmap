package com.benjamin.roadmapp.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Knowledge {

    private String id;
    private String name;
    private List<Knowledge> nextKnowledgeToLearn;

}
