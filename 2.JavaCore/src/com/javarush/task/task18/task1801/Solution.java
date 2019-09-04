package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        int max = 0;
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data > max) max = data;
        }
        System.out.println(max);

        reader.close();
        fileInputStream.close();
    }
}
