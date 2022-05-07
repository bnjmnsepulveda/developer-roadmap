package com.benjamin.roadmapp.infraestructure.neo4j.model;

import com.benjamin.roadmapp.domain.enumerate.LearningPriority;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Data
@ToString
@Builder
@RelationshipProperties
public class NextToLearnRelationship {

    @Id
    @GeneratedValue
    private Long id;
    private List<String> learningGoals;
    private LearningPriority priority;
    @TargetNode
    private KnowledgeNode knowledgeNode;


}
