package ru.javarush.cryptoanaliser.bogdanov.comands;

import ru.javarush.cryptoanaliser.bogdanov.entity.Result;
import ru.javarush.cryptoanaliser.bogdanov.entity.ResultCode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Decoder implements Action{
    @Override
    public Result execute(String[] parameters) {
        Path path = Paths.get(parameters[0]);
        Path path2 = Paths.get(parameters[1]);
        int step = Integer.parseInt(parameters[2]);
        String text;
        char[] chars;
        if (Files.exists(path)) {
            try {
                byte[] bytes = Files.readAllBytes(path);
                text = new String(bytes, StandardCharsets.UTF_8);
                StringBuilder stringBuilder = new StringBuilder();
                chars = text.toCharArray();
                for (char aChar : chars) {
                    if (((int) aChar >= 1040 && (int) aChar <= 1103)) {
                        stringBuilder.append((char) (aChar -step));
                    } else {
                        stringBuilder.append(aChar);
                    }
                    Files.writeString(path2, stringBuilder.toString());
                }





            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
   return new Result(ResultCode.OK,"Перевел.");
    }
}
