package ru.javarush.cryptoanaliser.bogdanov.comands;

import ru.javarush.cryptoanaliser.bogdanov.constants.Strings;
import ru.javarush.cryptoanaliser.bogdanov.entity.Result;
import ru.javarush.cryptoanaliser.bogdanov.entity.ResultCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bruteForce implements Action {
    @Override
    public Result execute(String[] parameters)  {
        Path path = Paths.get(parameters[0]);
        Path path2 = Paths.get(parameters[1]);
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String str1 = new String(bytes, StandardCharsets.UTF_8);

        int count=1;
        int countPrest =100;
        char[] alphubet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        char[] alphubetTop = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toUpperCase().toCharArray();
        char[] alphubetEng = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] alphubetEngTop = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
        char[] strings = str1.toCharArray();
        String[] countWords = str1.split(" ");

        Pattern pattern = Pattern.compile("\\b(мо|без|бес|во|воз|вос|возо|вз|вс|вы|до|за|из|изо|на|наи|недо|над|надо|не|низ|нис|" +
                "низо|об|обо|обез|обес|ото|па|пра|по|под|подо|пере|пре|пред|предо|при|про|раз|рас|разо|со|су|через|черес|чрез|ана|анти|архи|гипер|гипо|" +
                "де|дез|дис|ин|интер|инфра|квази|кило|контр|макро|микро|мега|мата|мульти|орто|пан|пара|пост|прото|ре|суб|супер|транс|ультра|зкстра|сказ|экс\\w)");

        Pattern patternEng = Pattern.compile("in|and|is|the|of|but|to|for");

        int dot;
        while (true) {
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < alphubet.length; j++) {

                    if ((int) strings[i] == (int) alphubet[j]) {
                        dot = j-count;
                        if (dot < 0) {
                            j = alphubet.length + dot;
                            dot = j;
                        }
                        strings[i] = alphubet[dot];
                        // stringBuilder.append(strings[i]);

                    } else if ((int) strings[i] == (int) alphubetTop[j]) {
                        dot = j-count;
                        if (dot < 0) {
                            j = alphubetTop.length + dot;
                            dot = j;
                        }
                        strings[i] = alphubetTop[dot];
                        //stringBuilder.append(strings[i]);

                    }

                }

            }
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < alphubetEng.length; j++) {

                    if ((int) strings[i] == (int) alphubetEng[j]) {
                        dot = j-count;
                        if (dot < 0) {
                            j = alphubetEng.length + dot;
                            dot = j;
                        }
                        strings[i] = alphubetEng[dot];
                        //stringBuilder.append(strings[i]);

                    } else if ((int) strings[i] == (int) alphubetEngTop[j]) {
                        dot = j-count;
                        if (dot < 0) {
                            j = alphubetEngTop.length + dot;
                            dot = j;
                        }
                        strings[i] = alphubetEngTop[dot];
                        //stringBuilder.append(strings[i]);

                    }
                }
                stringBuilder.append(strings[i]);
            }
//



            Matcher matcher = pattern.matcher(stringBuilder);
            int result= (int) matcher.results().count();
            Matcher matcherEng = patternEng.matcher(stringBuilder);
            int resultEng= (int) matcherEng.results().count();
            if(result!=0) {
                countPrest = (countWords.length / result);
            }

            if (resultEng >3||countPrest<7) {
                //System.out.println(stringBuilder);
                try {
                    Files.writeString(path2,stringBuilder);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                //System.out.println(countPrest);
                break;
            }

            stringBuilder.delete(0,str1.length());

        }
        //System.out.println(matcher.results().count());
        return new Result(ResultCode.OK,"Перевел.");
    }
}
