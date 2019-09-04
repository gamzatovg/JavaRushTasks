package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        BufferedReader line = new BufferedReader(new InputStreamReader(file));

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        String s;
        while ((s = line.readLine()) != null) {
            int number;
            if ((number = Integer.valueOf(s)) % 2 == 0) arrayList.add(number);
        }

        Collections.sort(arrayList);

        for (int num : arrayList) {
            System.out.println(num);
        }

        file.close();
    }
}
