package com.benjamin.roadmapp.infraestructure.application;

import com.benjamin.roadmapp.application.dto.CreateRoadMapDTO;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.service.RoadMapService;
import com.benjamin.roadmapp.utils.UnitTestBase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RoadMapEndpointTest extends UnitTestBase {

    @Mock
    RoadMapService service;

    @Test
    void createTest() {
        when(service.create(Mockito.any())).thenReturn(buildEntity("1", "backend","apis rest and business logic"));
        var app = new RoadMapEndpointApplication(service);
        var result = app.create(CreateRoadMapDTO.builder()
                        .name("backend")
                        .description("backend role")
                .build());
        assertThat(result.getName()).isEqualTo("backend");

    }

    @Test
    void findAllTest() {
        when(service.findAll()).thenReturn(
                Arrays.asList(
                        buildEntity("1","backend","back"),
                        buildEntity("2","frontend","front")
                )
        );
        var app = new RoadMapEndpointApplication(service);
        var result = app.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

    RoadMap buildEntity(String id, String name, String description){
        return RoadMap.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
