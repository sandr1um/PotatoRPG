package com.example.potatorpg.app;

import java.util.OptionalInt;
import java.util.Random;

public class Dice {
    public int roll() {
        Random rnd = new Random();
        OptionalInt random = rnd.ints(1, 6 + 1)
                .findFirst();
        return random.getAsInt();
    }
}
