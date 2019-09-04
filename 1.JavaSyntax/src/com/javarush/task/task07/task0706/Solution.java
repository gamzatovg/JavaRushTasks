package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sumOdd = 0; //нечетные
        int sumEven = 0; //четные
        int[] array = new int[15];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(reader.readLine());
            if (i % 2 == 0) {
                sumEven += array[i];
            } else {
                sumOdd += array[i];
            }
        }

        if (sumOdd > sumEven) {
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        } else if (sumEven > sumOdd) {
            System.out.println("В домах с четными номерами проживает больше жителей.");
        }
    }
}
