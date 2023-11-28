package com.example.potatorpg.rest;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Could not find event " + id);
    }
}
