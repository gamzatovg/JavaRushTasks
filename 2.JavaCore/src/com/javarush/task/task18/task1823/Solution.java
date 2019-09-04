package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName;
        while (!(fileName = reader.readLine()).equals("exit")) {
            new ReadThread(fileName).start();
        }

        reader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);

                int[] count = new int[128];
                while (fileInputStream.available() > 0) {
                    count[fileInputStream.read()]++;
                }

                int max = 0;
                for (int i = 1; i < count.length; i++) {
                    if (count[i] > count[max]) max = i;
                }

                resultMap.put(fileName, max);

                fileInputStream.close();
            } catch (IOException e) {
            }

        }
    }
}
