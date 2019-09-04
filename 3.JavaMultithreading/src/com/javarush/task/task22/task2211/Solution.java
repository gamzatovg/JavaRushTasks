package com.javarush.task.task22.task2211;

import java.io.*;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = new FileInputStream(args[0]);
             OutputStream outputStream = new FileOutputStream(args[1])
        ) {
            while (inputStream.available() != 0) {
                byte[] buffer = new byte[1024];
                int count = inputStream.read(buffer);
                String s = new String(buffer, 0, count, "Windows-1251");
                buffer = s.getBytes("UTF-8");
                outputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
