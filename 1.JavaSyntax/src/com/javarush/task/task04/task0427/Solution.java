package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.valueOf(reader.readLine());

        if (number > 0) {
            switch (String.valueOf(number).length()) {
                case (1):
                    System.out.println(number % 2 == 0 ? "четное однозначное число" : "нечетное однозначное число");
                    break;
                case (2):
                    System.out.println(number % 2 == 0 ? "четное двузначное число" : "нечетное двузначное число");
                    break;
                case (3):
                    System.out.println(number % 2 == 0 ? "четное трехзначное число" : "нечетное трехзначное число");
                    break;
                default:
                    break;
            }
        }
    }

}
