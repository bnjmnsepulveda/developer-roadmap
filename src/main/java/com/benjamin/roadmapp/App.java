package com.benjamin.roadmapp;

import com.benjamin.roadmapp.application.dto.*;
import com.benjamin.roadmapp.domain.entity.RoadMap;
import com.benjamin.roadmapp.domain.enumerate.LearningPriority;
import com.benjamin.roadmapp.infraestructure.application.api.service.KnowledgeEndpointService;
import com.benjamin.roadmapp.infraestructure.application.api.service.LanguageEndpointService;
import com.benjamin.roadmapp.infraestructure.application.api.service.RoadmapEndpointService;
import com.benjamin.roadmapp.infraestructure.neo4j.model.*;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.KnowledgeNeo4jRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.LanguageNeo4jRepository;
import com.benjamin.roadmapp.infraestructure.neo4j.repository.RoadMapNeo4jRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class App {


    @Autowired
    KnowledgeNeo4jRepository knowledgeNeo4jRepository;
    @Autowired
    LanguageNeo4jRepository languageNeo4jRepository;
    @Autowired
    RoadMapNeo4jRepository roadMapNeo4jRepository;
    @Autowired
    KnowledgeEndpointService knowledgeEndpointService;
    @Autowired
    LanguageEndpointService languageEndpointService;
    @Autowired
    RoadmapEndpointService roadMapEndpointService;


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready(ApplicationReadyEvent e) {

        /*
        // save knowledge
        var webKnowledge = build("web");
        webKnowledge.setNextToLearn(
                Arrays.asList(
                build("http"),
                build("jwt")
        ));
        var uiKnowledge = build("webpage design");
        uiKnowledge.setNextToLearn(
                Arrays.asList(
                        build("UX"),
                        build("UI Design")
                )
        );
        knowledgeNodeRepository.save(webKnowledge);
        knowledgeNodeRepository.save(uiKnowledge);


        // save languages
        var javascriptLanguage = build("javascript","non blocking", "dynamic typing","web", "backend");
        var languages = Arrays.asList(
                build("java","safe typing", "blocking", "poo"),
                build("python", "dynamic typing", "scripting", "multi paradigm"),
                javascriptLanguage

        );
        languages.forEach(languageNodeRepository::save);

        var backRoadmap = build("backend", "Backend dev profile for web apps", Arrays.asList(webKnowledge), languages );
        roadMapNeo4jRepository.save(backRoadmap);

        var frontRoadmap = build("frontend", "Web and user interface development", Arrays.asList(webKnowledge, uiKnowledge), Arrays.asList(javascriptLanguage));
        roadMapNeo4jRepository.save(frontRoadmap);

*/


        languageNeo4jRepository.deleteAll();
        knowledgeNeo4jRepository.deleteAll();
        roadMapNeo4jRepository.deleteAll();

        var database = build("database");

        var sql = build("sql");
        var noSql = build("no-sql");

        var relSql = NextToLearnRelationship.builder()
                .learningGoals(Arrays.asList(
                        "persistence data",
                        "modeling business data"
                ))
                .knowledgeNode(sql)
                .priority(LearningPriority.REQUIRED)
                .build();

        var relNoSql = NextToLearnRelationship.builder()
                .learningGoals(Arrays.asList(
                        "persistence data",
                        "structured data alternatives"
                ))
                .knowledgeNode(noSql)
                .priority(LearningPriority.RECOMMENDED)
                .build();

        database.setNextToLearn(Arrays.asList(relSql, relNoSql));
        knowledgeNeo4jRepository.save(database);

        var backRoadmap = RoadMapNode.builder()
                .id("be")
                .name("backend")
                .description("server side implementation")
                .build();
        roadMapNeo4jRepository.save(backRoadmap);

        var updated = roadMapEndpointService.addKnowledge(AddKnowledgeToRoadMapDTO.builder()
                        .knowledgeId("database")
                        .roadMapId("be")
                        .learningGoals(Arrays.asList("store data applications is required"))
                        .priority(LearningPriority.REQUIRED)
                .build());
        System.out.println("knowledge updated=" + updated);


        var batch = new CreateKnowledgeDTO("apache spark");
        knowledgeEndpointService.create(batch);

        languageEndpointService.create(CreateLanguageDTO.builder()
                .name("scala")
                .properties(Arrays.asList("JVM compatible", "scripting"))
                .build());
        languageEndpointService.create(CreateLanguageDTO.builder()
                .name("java")
                .properties(Arrays.asList("safe type", "blocking thread"))
                .build());
        languageEndpointService.create(CreateLanguageDTO.builder()
                .name("python")
                .properties(Arrays.asList("dynamic type", "scripting" ,"FP", "POO"))
                .build());
        languageEndpointService.findAll().forEach(System.out::println);
        var languagesID = languageEndpointService.findAll().stream().map(LanguageDTO::getId).collect(Collectors.toList());


        var backend = roadMapEndpointService.create(CreateRoadMapDTO.builder()
                .name("backend")
                .description("server implementation for business logic")
                .build());

        roadMapEndpointService.create(CreateRoadMapDTO.builder()
                .name("frontend")
                .description("user interfaces for web or mobile applications")
                .build());

        roadMapEndpointService.updateLanguages(backend.getId(), languagesID);
        roadMapEndpointService.findAll().forEach(System.out::println);




        /*knowledgeEndpointService
                .findAll()
                .forEach(System.out::println);*/

    }

    RoadMapNode build(String name, String description, List<KnowledgeNode> knowledgeToLearn, List<LanguageNode> languageToDomain){
        return RoadMapNode.builder()
                .name(name)
                .description(description)
              //  .knowledgeToLearn(knowledgeToLearn)
                .languagesToDomain(languageToDomain)
                .build();
    }

    KnowledgeNode build(String name) {
        return KnowledgeNode.builder()
                .name(name)
                .build();
    }

    LanguageNode build(String name, String... properties){
        return LanguageNode.builder()
                .name(name)
                .properties(Arrays.asList(properties))
                .build();
    }


}
