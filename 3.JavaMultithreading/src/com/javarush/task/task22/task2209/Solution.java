package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) stringBuilder.append(fileReader.readLine().concat(" "));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            StringBuilder result = getLine(stringBuilder.toString().split(" "));
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder[] stringBuilders = new StringBuilder[words.length];

        for (int k = 0; k < words.length; k++) {
            StringBuilder stringBuilder = new StringBuilder(words[k]);
            String[] clonedWords = words.clone();
            clonedWords[k] = "";

            for (int i = 0; i < clonedWords.length; i++) {
                if (clonedWords[i].equals("")) continue;
                if (clonedWords[i].toLowerCase().startsWith(String.valueOf(stringBuilder.charAt(stringBuilder.length() - 1)).toLowerCase())) {
                    stringBuilder.append(" ".concat(clonedWords[i]));
                    clonedWords[i] = "";
                    i = 0;
                }
            }

            stringBuilders[k] = stringBuilder;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder s : stringBuilders) if (s.length() > result.length()) result = s;

        return result;
    }
}
