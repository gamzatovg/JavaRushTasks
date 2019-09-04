package com.javarush.task.task03.task0308;

/* 
Произведение 10 чисел
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int p = 1;
        for (int i = 1; i <= 10; i++) {
            p *= i;
        }
        System.out.println(p);
    }
}
