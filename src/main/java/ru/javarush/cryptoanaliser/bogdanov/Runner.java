package ru.javarush.cryptoanaliser.bogdanov;

import ru.javarush.cryptoanaliser.bogdanov.application.Application;
import ru.javarush.cryptoanaliser.bogdanov.controller.Maincontroller;

public class Runner {
    public static void main(String[] args) {
        Maincontroller maincontroller = new Maincontroller();
        Application application = new Application(maincontroller);
        Results results = application.run(args);
    }
}