package com.benjamin.roadmapp.domain.exception;

public class RoadMapNotFoundException extends RuntimeException{

    public RoadMapNotFoundException(String id) {
        super("RoadMap(id='" +id + "') Not Found");
    }
}
