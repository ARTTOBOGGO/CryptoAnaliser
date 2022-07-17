package ru.javarush.cryptoanaliser.bogdanov.toplevel;

import ru.javarush.cryptoanaliser.bogdanov.entity.Result;
import ru.javarush.cryptoanaliser.bogdanov.controller.MainController;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Application {
private  final MainController maincontroller ;

    public Application(MainController maincontroller) {
        this.maincontroller = maincontroller;
    }

    public Result run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String[] parametrs = new String[3];
        String[] inputParametrs = new String[3];

        String pathOfFileFrom = scanner.nextLine();
        String pathOfFileTo = scanner.nextLine();
        String step = scanner.nextLine();


        if(Objects.equals(operation, "")){
            operation = args[0];
        }
        if(!pathOfFileFrom.equals("")){
            parametrs[0]=pathOfFileFrom;
        }else{
            parametrs[0]=args[1];
        }
        if(!pathOfFileTo.equals("")){
            parametrs[1]=pathOfFileTo;
        }else {
            parametrs[1]=args[2];
        }
        if(!step.equals("")){
            parametrs[2]=step;
        }else{
            parametrs[2]=args[3];
        }
        return this.maincontroller.execute(operation,parametrs);
    }
}
