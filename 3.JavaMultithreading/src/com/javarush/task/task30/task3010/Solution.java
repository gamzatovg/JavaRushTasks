package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int radix = 2; radix <= 36; radix++) {
            try {
                new BigInteger(args[0], radix);

                System.out.println(radix);
                return;
            } catch (Exception e) {
            }
        }

        System.out.println("incorrect");
    }
}