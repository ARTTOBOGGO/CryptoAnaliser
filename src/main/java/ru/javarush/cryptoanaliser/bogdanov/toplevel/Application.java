package ru.javarush.cryptoanaliser.bogdanov.toplevel;

import ru.javarush.cryptoanaliser.bogdanov.entity.Result;
import ru.javarush.cryptoanaliser.bogdanov.controller.MainController;

import java.util.Arrays;

public class Application {
private  final MainController maincontroller ;

    public Application(MainController maincontroller) {
        this.maincontroller = maincontroller;
    }

    public Result run(String[] args) {
        String operation = args[0];
        String[] parametrs = Arrays.copyOfRange(args,1 ,args.length);

        return this.maincontroller.execute(operation,parametrs);
    }
}
