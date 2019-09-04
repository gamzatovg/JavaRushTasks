package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Arguments: -mode(e/d) fileName fileOutputName");
            return;
        }

        switch (args[0]) {
            case "-e":
                cipher(Mode.ENCODE, args[1], args[2]);
                break;
            case "-d":
                cipher(Mode.DECODE, args[1], args[2]);
                break;
        }
    }

    public static void cipher(Mode mode, String fileName, String fileOutputName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

            if (mode == Mode.ENCODE) {
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data == 127 ? 0 : ++data);
                }
            } else if (mode == Mode.DECODE) {
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    fileOutputStream.write(data == 0 ? 127 : --data);
                }
            } else {
                System.out.println("Unknown mode");
            }

            fileOutputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
