package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.MIN_VALUE, key, N = Integer.parseInt(reader.readLine());

        //напишите тут ваш код
        for (int i = 0; i < N; i++) {
            if ((key = Integer.parseInt(reader.readLine())) > maximum) {
                maximum = key;
            }
        }

        System.out.println(maximum);
    }
}
