package com.benjamin.roadmapp.infraestructure.neo4j.model;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@ToString
@Builder
@Node("Knowledge")
public class KnowledgeNode {

    @Id
    private String name;
    @Relationship(type = "NEXT_TO_LEARN")
    private List<NextToLearnRelationship> nextToLearn;

    public static KnowledgeNode map(Knowledge entity) {

        return KnowledgeNode.builder()
                .name(entity.getName())
                .build();

    }

    public static Knowledge toEntity(KnowledgeNode node) {

        Function<KnowledgeNode, Knowledge> buildEntity = (KnowledgeNode n) -> Knowledge.builder()
                .name(n.name)
                .build();

        var entity = buildEntity.apply(node);

        if (node.getNextToLearn() == null) {
            return entity;
        }

        var nextToLearn = node
                .getNextToLearn()
                .stream()
                .map(NextToLearnRelationship::getKnowledgeNode)
                .map(KnowledgeNode::toEntity)
                .collect(Collectors.toList());

        entity.setNextKnowledgeToLearn(nextToLearn);
        return entity;

    }

}
