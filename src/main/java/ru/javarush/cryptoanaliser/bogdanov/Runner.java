package ru.javarush.cryptoanaliser.bogdanov;

import ru.javarush.cryptoanaliser.bogdanov.toplevel.Application;
import ru.javarush.cryptoanaliser.bogdanov.controller.MainController;
import ru.javarush.cryptoanaliser.bogdanov.entity.Result;

public class Runner {
    public static void main(String[] args) {
        MainController maincontroller = new MainController();
        Application application = new Application(maincontroller);
        Result results = application.run(args);
        System.out.println(results.toString());
    }
}