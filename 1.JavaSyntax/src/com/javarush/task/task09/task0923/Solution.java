package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Character> vowels = new ArrayList<Character>();
        ArrayList<Character> others = new ArrayList<Character>();

        String string = reader.readLine();

        for (Character ch : string.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            } else if (ch != ' ') {
                others.add(ch);
            }
        }

        for (char ch : vowels) {
            System.out.print(ch + " ");
        }
        System.out.println();
        for (char ch : others) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}