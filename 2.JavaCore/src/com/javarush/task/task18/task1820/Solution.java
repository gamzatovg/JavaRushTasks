package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reader.readLine()));

        StringBuffer stringBuffer = new StringBuffer();
        while (fileReader.ready()) {
            stringBuffer.append(fileReader.readLine() + " ");
        }

        StringBuffer result = new StringBuffer();
        for (String string : stringBuffer.toString().split(" ")) {
            result.append(Math.round(Double.valueOf(string)) + " ");
        }

        fileWriter.write(result.toString());

        reader.close();
        fileReader.close();
        fileWriter.close();
    }
}