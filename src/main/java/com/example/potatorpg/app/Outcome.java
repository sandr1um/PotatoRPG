package com.example.potatorpg.app;

import java.util.HashMap;
import java.util.Map;

public class Outcome {
    private final Map<Attribute, Integer> attributesToChange;

    public Outcome() {
        this.attributesToChange = new HashMap<>();
    }

    public void setAttribute(Attribute attribute, int value) {
        this.attributesToChange.put(attribute, value);
    }

    public int getChange(Attribute attribute) {
        return attributesToChange.get(attribute);
    }

}
