package com.benjamin.roadmapp;

import com.benjamin.roadmapp.domain.entity.Knowledge;
import com.benjamin.roadmapp.domain.entity.Language;
import com.benjamin.roadmapp.domain.ports.outgoing.GenerateUniqueID;
import com.benjamin.roadmapp.domain.ports.outgoing.KnowledgeRepository;
import com.benjamin.roadmapp.domain.ports.outgoing.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
public class App {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    GenerateUniqueID generateUniqueID;
    @Autowired
    KnowledgeRepository knowledgeRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready(ApplicationReadyEvent e) {
        System.out.println("App ready");
        Arrays
                .asList(
                        build("java", "safe typing", "compiled"),
                        build("python", "dynamic types", "interpreted")
                )
                .stream()
                .forEach(languageRepository::save);

        Arrays
                .asList(
                        build("http"),
                        build("linux"),
                        build("git")
                )
                .stream()
                .forEach(knowledgeRepository::save);
    }

    Language build(String name, String... properties) {
        return Language.builder()
                .id(generateUniqueID.handle())
                .name(name)
                .properties(Arrays.asList(properties))
                .build();
    }

    Knowledge build(String name) {
        return Knowledge.builder()
                .id(generateUniqueID.handle())
                .name(name)
                .build();
    }

}
