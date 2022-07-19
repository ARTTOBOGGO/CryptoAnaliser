package ru.javarush.cryptoanaliser.bogdanov.controller;

import ru.javarush.cryptoanaliser.bogdanov.comands.*;

public enum Actions {
    ENCODER(new Encoder()),
    DECODER(new Decoder()),
    BRUTEFORCE(new BruteForce()),
    STATISTICS(new Statistics());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String operation) {
        return Actions.valueOf(operation.toUpperCase()).action;
    }
}
