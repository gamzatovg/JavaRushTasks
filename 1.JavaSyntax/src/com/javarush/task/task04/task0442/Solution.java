package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int key = 0;
        while (key != -1) {
            key = Integer.valueOf(reader.readLine());
            sum += key;
        }
        System.out.println(sum);
    }
}
