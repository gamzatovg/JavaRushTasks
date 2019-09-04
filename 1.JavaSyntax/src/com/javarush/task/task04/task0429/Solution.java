package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number;
        int neg = 0;
        int pos = 0;
        for (int i = 0; i < 3; i++) {
            number = Integer.valueOf(reader.readLine());
            if (number < 0) {
                neg++;
            } else if (number > 0) {
                pos++;
            }
        }
        System.out.println("количество отрицательных чисел: " + neg);
        System.out.println("количество положительных чисел: " + pos);
    }
}
