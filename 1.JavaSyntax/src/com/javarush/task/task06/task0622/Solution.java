package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int array[] = new int[5];
        for (int i = 0; i < 5; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int prevent = i - 1;
            while (prevent >= 0 && array[prevent] > current) {
                array[prevent + 1] = array[prevent];
                prevent--;
            }
            array[prevent + 1] = current;
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
