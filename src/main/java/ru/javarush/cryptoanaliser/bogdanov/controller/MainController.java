package ru.javarush.cryptoanaliser.bogdanov.controller;

import ru.javarush.cryptoanaliser.bogdanov.comands.Action;
import ru.javarush.cryptoanaliser.bogdanov.entity.Result;

public class MainController {
    public Result execute(String operation, String[] parametrs) {
        Action action = Actions.find(operation);
        return action.execute(parametrs);

    }
}
