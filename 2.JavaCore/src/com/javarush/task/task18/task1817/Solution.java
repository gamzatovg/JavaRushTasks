package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int symbols = 0;
        int spaces = 0;

        while (fileInputStream.available() > 0) {
            symbols++;
            if (fileInputStream.read() == 32) spaces++;
        }

        System.out.println(String.format("%.2f", (double) spaces / symbols * 100));

        fileInputStream.close();
    }
}
