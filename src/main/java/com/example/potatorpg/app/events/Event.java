package com.example.potatorpg.app.events;

import com.example.potatorpg.app.Outcome;

import lombok.Getter;

@Getter
public abstract class Event {
    protected String message;
    Outcome result;

    public Event() {
        this.message = "";
        this.result = new Outcome();
    }

    public abstract Event generateEvent(int diceResult);

    public void setMessage(String message) {
        this.message = message;
    }
}
