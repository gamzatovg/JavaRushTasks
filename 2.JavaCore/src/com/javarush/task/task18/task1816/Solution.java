package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream(args[0]);

            int count = 0;

            while (fileInputStream.available() > 0) {
                int code = fileInputStream.read();
                if ((code >= 65 && code <= 90) || (code >= 97 && code <= 122)) count++;
            }

            System.out.println(count);

            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
