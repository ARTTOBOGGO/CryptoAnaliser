package ru.javarush.cryptoanaliser.bogdanov.controller;

import ru.javarush.cryptoanaliser.bogdanov.comands.Action;
import ru.javarush.cryptoanaliser.bogdanov.comands.Decoder;
import ru.javarush.cryptoanaliser.bogdanov.comands.Encoder;

public enum Actions {
    ENCODE(new Encoder()),
    DECODE(new Decoder());

    private final Action action;

    Actions(Action action) {
        this.action = action;
    }

    public static Action find(String operation) {
        return Actions.valueOf(operation.toUpperCase()).action;
    }
}
