package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = reader.readLine();
            FileInputStream file = new FileInputStream(fileName);

            while (file.available() > 0) {
                System.out.print((char) file.read());
            }

            file.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }
    }
}