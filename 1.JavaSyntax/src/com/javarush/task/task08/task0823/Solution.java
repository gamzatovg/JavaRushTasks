package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String[] words = s.split("\\s");

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();

            if (chars.length != 0) {
                chars[0] = Character.toUpperCase(chars[0]);
            }

            words[i] = new String(chars);
        }

        System.out.println(String.join(" ", words));
    }
}
