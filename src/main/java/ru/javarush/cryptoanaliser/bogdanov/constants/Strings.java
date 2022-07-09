package ru.javarush.cryptoanaliser.bogdanov;

import java.util.Locale;

public class Strings {
    private static String rus ="йцукенгшщзхъфывапролджэячсмитьбю";
    private static String eng ="qwerttyuiopasdfghjklzxcvbnm";
    private static String num ="1234567890";
    private static String symbol =".,?!";
    
    public static String allsymbols = rus+ rus.toUpperCase()+eng+ eng.toUpperCase()+num+symbol;

}
