package com.example.potatorpg.app;

import java.util.OptionalInt;
import java.util.Random;

public class Dice {
    private static final Random rnd = new Random();

    public int roll() {
        return rnd.nextInt(6) + 1;
    }
}
