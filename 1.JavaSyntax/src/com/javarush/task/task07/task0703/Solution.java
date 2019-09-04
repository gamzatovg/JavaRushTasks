package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[10];
        int[] numbers = new int[10];

        for (int i = 0; i < lines.length; i++) {
            lines[i] = reader.readLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lines[i].length();
            System.out.println(numbers[i]);
        }
    }
}
