package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        String fileName = args[0];
        long   number   = Long.parseLong(args[1]);
        String text     = args[2];

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            int textLength = text.length();
            byte[] bytes = new byte[textLength];
            raf.seek(number);
            raf.read(bytes, 0, textLength);
            String readText = new String(bytes);

            raf.seek(raf.length());

            if (text.equals(readText)) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
