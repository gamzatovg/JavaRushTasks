package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileReader fileReader = new FileReader(bufferedReader.readLine());

        bufferedReader.close();

        int count = 0;
        String word = "world";
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            int data = fileReader.read();

            if (Character.isLetter(data)) {
                stringBuilder.append((char) data);
            } else {
                if (word.equals(stringBuilder.toString())) count++;
                stringBuilder.setLength(0);
            }
        }
        if (word.equals(stringBuilder.toString())) count++;

        System.out.println(count);

        fileReader.close();
    }
}
