package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());

        if (fileInputStream.available() > 0) {
            byte[] data = new byte[fileInputStream.available()];
            int count = fileInputStream.read(data);

            for (int i = 0; i < data.length / 2; i++) {
                byte temp = data[i];
                data[i] = data[data.length - i - 1];
                data[data.length - i - 1] = temp;
            }

            fileOutputStream.write(data, 0, count);
        }

        reader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
