package ru.javarush.cryptoanaliser.bogdanov.application;

import ru.javarush.cryptoanaliser.bogdanov.Results;
import ru.javarush.cryptoanaliser.bogdanov.controller.Maincontroller;

import java.util.Arrays;

public class Application {
private  final Maincontroller maincontroller ;

    public Application(Maincontroller maincontroller) {
        this.maincontroller = maincontroller;
    }

    public Results run(String[] args) {
        String operation = args[0];
        String[] parametrs = Arrays.copyOfRange(args,1 ,args.length);
         Results results=this.maincontroller.execute(operation,parametrs);

        return results;
    }
}
