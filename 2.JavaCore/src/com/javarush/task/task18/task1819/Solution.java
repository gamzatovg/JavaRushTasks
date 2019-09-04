package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(fileName1);
        FileInputStream fileInputStream2 = new FileInputStream(fileName2);

        if (fileInputStream2.available() > 0) {
            byte[] data1 = new byte[fileInputStream1.available()];
            int count1 = fileInputStream1.read(data1);

            byte[] data2 = new byte[fileInputStream2.available()];
            int count2 = fileInputStream2.read(data2);

            byte[] data = new byte[count2 + count1];
            System.arraycopy(data2, 0, data, 0, count2);
            System.arraycopy(data1, 0, data, count2, count1);

            fileOutputStream1.write(data, 0, count2 + count1);
        }

        fileInputStream1.close();
        fileOutputStream1.close();
        fileInputStream2.close();
    }
}
