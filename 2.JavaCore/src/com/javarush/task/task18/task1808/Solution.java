package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());

        int halfOfSize = fileInputStream.available() / 2;

        while (fileInputStream.available() > halfOfSize) {
            fileOutputStream1.write(fileInputStream.read());
        }

        while (fileInputStream.available() > 0) {
            fileOutputStream2.write(fileInputStream.read());
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
    }
}
