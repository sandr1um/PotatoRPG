package com.example.potatorpg.app;

import com.example.potatorpg.app.events.Event;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class GameState {
    private final Map<Attribute, Integer> scores;

    public GameState() {
        this.scores = new HashMap<>();
    }

    public void applyEvent(Event event) {
        this.scores.keySet()
                .forEach(item -> changeScore(item, event.getResult().getChange(item)));
    }

    public boolean isFinished() {
        return this.scores.values().stream().anyMatch(item -> item == 10);
    }

    private void changeScore(Attribute attribute, int change) {
        int changes = scores.get(attribute) + change;
        if (changes >= 0) {
            scores.put(attribute, changes);
        }
    }

    public String generateFinalMessage() {
        Attribute endAttribute = scores.keySet()
                .stream()
                .filter(item -> scores.get(item) == 10)
                .findAny().get();

        return switch (endAttribute) {
            case DESTINY ->"An interfering bard or wizard turns up at your doorstep with a quest," +
                    " and you are whisked away against your will on an adventure.";
            case POTATOES -> "You have enough potatoes that you can go underground and not return to the surface" +
                    " until the danger is past. You nestle down into your burrow and enjoy your well earned rest";
            case ORCS -> "Orcs have finally find your potato farm. Alas, orcs are not so interested in potatoes as they" +
                    " are in eating you, and you end up in a cockpot";
            case SCALING -> "";
        };
    }
}