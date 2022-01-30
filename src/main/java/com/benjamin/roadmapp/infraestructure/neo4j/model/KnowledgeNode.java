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

        Function<Knowledge, KnowledgeNode> basicNode = (Knowledge k) -> KnowledgeNode.builder()
                .name(k.getName())
                .build();

        var node = basicNode.apply(entity);

        if (entity.getNextKnowledgeToLearn() == null) {
            return node;
        }

        var nextToLearnNodes = entity
                .getNextKnowledgeToLearn()
                .stream()
                .map(basicNode)
                .collect(Collectors.toList());

        //node.setNextToLearn(nextToLearnNodes);
        return node;

    }

    public static Knowledge toEntity(KnowledgeNode node) {

        Function<KnowledgeNode, Knowledge> buildEntity = (KnowledgeNode n) -> Knowledge.builder()
                .id(n.name)
                .name(n.name)
                .build();

        var entity = buildEntity.apply(node);
        return entity;
       /* if (node.getNextToLearn() == null) {
            return entity;
        }

        var nextToLearn = node
                .getNextToLearn()
                .stream()
                .map(buildEntity)
                .collect(Collectors.toList());

        entity.setNextKnowledgeToLearn(nextToLearn);
        return entity;*/

    }

}
