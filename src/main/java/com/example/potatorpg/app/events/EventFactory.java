package com.example.potatorpg.app.events;

import com.example.potatorpg.app.Dice;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventFactory {

    private final Dice dice;
    public Event createEvent() {
        int firstDiceRoll = dice.roll();
        return switch (firstDiceRoll) {
            case 1,2 -> new GardenEvent(dice.roll());
            case 3,4 -> new DoorEvent(dice.roll());
            case 5,6 -> new DarkEvent();
            default -> throw new IllegalStateException("Unexpected value: " + firstDiceRoll);
        };
    }
}
