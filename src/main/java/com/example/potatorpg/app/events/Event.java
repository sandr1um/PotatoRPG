package com.example.potatorpg.app.events;

import com.example.potatorpg.app.Outcome;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Event {
    @Setter
    protected String message = "";
    protected Outcome result = new Outcome();

    public abstract Event generateEvent(int diceResult);

}
