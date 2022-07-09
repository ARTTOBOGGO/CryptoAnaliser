package ru.javarush.cryptoanaliser.bogdanov.comands;

import ru.javarush.cryptoanaliser.bogdanov.entity.Result;

public interface Action {
    Result execute(String[] parameters);
}
