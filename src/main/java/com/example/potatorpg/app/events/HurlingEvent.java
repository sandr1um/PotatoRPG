package com.example.potatorpg.app.events;

import com.example.potatorpg.app.Attribute;

public class HurlingEvent extends Event {

    public HurlingEvent() {
        super.message = "-1 Orc, -1 Potato";
        super.result.setAttribute(Attribute.ORCS, -1);
        super.result.setAttribute(Attribute.POTATOES, -1);
    }
    @Override
    public Event generateEvent(int diceResult) {
        return new HurlingEvent();
    }
}
