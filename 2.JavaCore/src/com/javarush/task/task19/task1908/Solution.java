package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        bufferedReader.close();

        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            String[] strings = fileReader.readLine().split(" ");

            for (String s : strings) {
                try {
                    int i = Integer.parseInt(s);
                    stringBuilder.append(i).append(" ");
                } catch (NumberFormatException e) {
                }
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            if (!flag) {
                fileWriter.write(stringBuilder.toString());
                flag = true;
            } else {
                fileWriter.write(stringBuilder.insert(0, "\n").toString());
            }

            stringBuilder.setLength(0);
        }

        fileWriter.close();
        fileReader.close();
    }
}
