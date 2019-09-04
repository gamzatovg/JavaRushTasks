package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        bufferedReader.close();

        while (fileReader.ready()) {
            String string = fileReader.readLine().replaceAll("\\p{Punct}", "");

            fileWriter.write(string);
        }

        fileWriter.close();
        fileReader.close();
    }
}
