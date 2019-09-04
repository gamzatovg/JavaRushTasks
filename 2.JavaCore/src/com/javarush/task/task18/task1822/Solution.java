package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        int id = Integer.parseInt(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        reader.close();

        while (fileReader.ready()) {
            String line = fileReader.readLine();
            int currentId = Integer.parseInt(line.split(" ")[0]);

            if (currentId == id) {
                System.out.println(line);
                break;
            }
        }

        fileReader.close();
    }
}
