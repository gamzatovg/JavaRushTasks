package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double sum = 0.0, key;
        int count = 0;
        while ((key = Double.valueOf(reader.readLine())) != -1) {
            sum += key;
            count++;
        }

        System.out.println(sum / count);
    }
}

