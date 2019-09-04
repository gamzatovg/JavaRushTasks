package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = reader.readLine();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            while (true) {
                String string = reader.readLine();
                bufferedWriter.write(string + "\n");
                if (string.equals("exit")) break;
            }

            bufferedWriter.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
