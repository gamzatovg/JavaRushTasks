package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        strings = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            strings.add(reader.readLine());
        }

        int maxSize = strings.get(0).length();
        for (String s : strings) {
            if (s.length() > maxSize) {
                maxSize = s.length();
            }
        }

        for (String s : strings) {
            System.out.print(s.length() == maxSize ? s + "\n" : "");
        }
    }
}
