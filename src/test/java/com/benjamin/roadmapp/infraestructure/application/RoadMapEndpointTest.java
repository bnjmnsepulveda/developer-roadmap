package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.service.KnowledgeService;
import com.benjamin.roadmapp.domain.service.LanguageService;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import com.benjamin.roadmapp.infraestructure.application.objectmother.KnowledgeObjectMother;
import com.benjamin.roadmapp.infraestructure.application.objectmother.LanguageObjectMother;
import com.benjamin.roadmapp.utils.UnitTestBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RoadMapEndpointTest extends UnitTestBase {

    @Mock
    RoadMapService roadMapService;
    @Mock
    KnowledgeService knowledgeService;
    @Mock
    LanguageService languageService;

    @Test
    void createTest() {
        when(roadMapService.create(Mockito.any())).thenReturn(buildEntity("1", "backend","apis rest and business logic"));
        var app = RoadMapEndpointApplication.builder()
                .roadMapService(roadMapService)
                .build();
        var result = app.create(CreateRoadMapDTO.builder()
                        .name("backend")
                        .description("backend role")
                .build());
        assertThat(result.getName()).isEqualTo("backend");

    }

    @Test
    void findAllTest() {
        when(roadMapService.findAll()).thenReturn(
                Arrays.asList(
                        buildEntity("1","backend","back"),
                        buildEntity("2","frontend","front")
                )
        );
        var app = RoadMapEndpointApplication.builder()
                .roadMapService(roadMapService)
                .build();
        var result = app.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    @Test
    void updateLanguageTest() {

        var entity = buildEntity("1","backend","back");
        var language = Arrays.asList(
                LanguageObjectMother.buildLanguage("1","java")
        );

        when(roadMapService.findById("1")).thenReturn(entity);
        when(languageService.findByIds(Arrays.asList("1"))).thenReturn(language);

        var entityUpdated = entity;
        entityUpdated.setLanguagesToDomain(language);

        when(roadMapService.update(entity)).thenReturn(entityUpdated);

        var app = RoadMapEndpointApplication.builder()
                .roadMapService(roadMapService)
                .languageService(languageService)
                .build();

        var result = app.updateLanguage(entity.getId(), Arrays.asList("1"));

        assertThat(result.getRoadMapName()).isEqualTo("backend");
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getLanguages().size()).isEqualTo(1);

    }

    @Test
    void updateKnowledgeTest() {

        var entity = buildEntity("1","backend","back");
        var knowledge = Arrays.asList(
                KnowledgeObjectMother.buildKnowledge("1","http"),
                KnowledgeObjectMother.buildKnowledge("1","linux")
        );

        when(roadMapService.findById("1")).thenReturn(entity);
        when(knowledgeService.findByIds(Arrays.asList("1","2"))).thenReturn(knowledge);

        var entityUpdated = entity;
        entityUpdated.setKnowledgeToDomain(knowledge);

        when(roadMapService.update(entity)).thenReturn(entityUpdated);

        var app = RoadMapEndpointApplication.builder()
                .roadMapService(roadMapService)
                .knowledgeService(knowledgeService)
                .build();

        var result = app.updateKnowledge(entity.getId(), Arrays.asList("1", "2"));

        assertThat(result.getRoadMapName()).isEqualTo("backend");
        assertThat(result.getId()).isEqualTo("1");
        assertThat(result.getKnowledge().size()).isEqualTo(2);

    }

    RoadMap buildEntity(String id, String name, String description){
        return RoadMap.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
