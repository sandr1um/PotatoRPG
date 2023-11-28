package com.example.potatorpg.app.events;

import com.example.potatorpg.app.Attribute;

public class DarkEvent extends Event {

    public DarkEvent() {
        super.result.setAttribute(Attribute.SCALING, 1);
        super.message = "The world becomes a darker, more dangerous place. " +
                "From now on, removing ORC costs an additional POTATO.";
    }

    @Override
    public Event generateEvent(int diceRoll) {
        return new DarkEvent();
    }
}
