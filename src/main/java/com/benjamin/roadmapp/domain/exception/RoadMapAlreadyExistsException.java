package com.benjamin.roadmapp.domain.exception;

public class RoadMapAlreadyExistsException extends RuntimeException{
    public RoadMapAlreadyExistsException(String name) {
        super("RoadMap(name=" + name + ") AlreadyExists");
    }
}
