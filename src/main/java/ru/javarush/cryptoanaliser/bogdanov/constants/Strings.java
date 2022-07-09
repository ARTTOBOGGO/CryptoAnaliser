package ru.javarush.cryptoanaliser.bogdanov.constants;

import java.util.Locale;

public class Strings {
    private static final String rus ="йцукенгшщзхъфывапролджэячсмитьбю";
    private static final String eng ="qwerttyuiopasdfghjklzxcvbnm";
    private static final String num ="1234567890";
    private static final String symbol =".,?!";

    public static String allSymbols = rus+ rus.toUpperCase()+eng+ eng.toUpperCase()+num+symbol;

}
