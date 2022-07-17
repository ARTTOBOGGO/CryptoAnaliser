package ru.javarush.cryptoanaliser.bogdanov.controller;

import ru.javarush.cryptoanaliser.bogdanov.comands.Action;
import ru.javarush.cryptoanaliser.bogdanov.comands.Decoder;
import ru.javarush.cryptoanaliser.bogdanov.comands.Encoder;
import ru.javarush.cryptoanaliser.bogdanov.comands.BruteForce;

public enum Actions {
    ENCODER(new Encoder()),
    DECODER(new Decoder()),
    BRUTEFORCE(new BruteForce());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String operation) {
        return Actions.valueOf(operation.toUpperCase()).action;
    }
}
