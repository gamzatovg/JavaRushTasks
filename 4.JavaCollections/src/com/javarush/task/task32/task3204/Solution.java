package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        int size = 8;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(size);
        Random random = new Random(System.nanoTime());
        while (!baos.toString().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")) {
            baos.reset();
            int i = 0;
            for (int k = 0; k < size; ++k) {
                switch (random.nextInt(3)) {
                    case 0:
                        i = random.nextInt(10) + 48; // digits
                        break;
                    case 1:
                        i = random.nextInt(26) + 65; // uppercase chars
                        break;
                    case 2:
                        i = random.nextInt(26) + 97; // lowercase chars
                        break;
                }
                baos.write(i);
            }
        }

        return baos;
    }
}