package com.benjamin.roadmapp;

import com.benjamin.roadmapp.infraestructure.neo4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class App {


    @Autowired
    KnowledgeNodeRepository knowledgeNodeRepository;
    @Autowired
    LanguageNodeRepository languageNodeRepository;
    @Autowired
    RoadMapNeo4jRepository roadMapNeo4jRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready(ApplicationReadyEvent e) {
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

    }

    RoadMapNode build(String name,String description, List<KnowledgeNode> knowledgeToLearn, List<LanguageNode> languageToDomain){
        return RoadMapNode.builder()
                .name(name)
                .description(description)
                .knowledgeToLearn(knowledgeToLearn)
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
