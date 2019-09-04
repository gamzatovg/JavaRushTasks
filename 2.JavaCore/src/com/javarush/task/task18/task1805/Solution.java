package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        Set<Integer> set = new TreeSet(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return Integer.compare(i1, i2);
            }
        });

        while (fileInputStream.available() > 0) {
            set.add(fileInputStream.read());
        }

        for (Integer i : set) {
            System.out.print(i + " ");
        }

        reader.close();
        fileInputStream.close();
    }
}
