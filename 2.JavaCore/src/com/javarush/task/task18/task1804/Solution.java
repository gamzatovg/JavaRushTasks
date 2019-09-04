package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            list.add(data);
        }

        int size = list.size();
        int[] count = new int[size];
        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < size; i++) {
            count[i] = 0;
            for (int j = 0; j < size; j++) {
                if (list.get(i).equals(list.get(j))) count[i]++;
            }
            if (count[i] < minCount) minCount = count[i];
        }

        for (int i = 0; i < size; i++) {
            if (count[i] == minCount) System.out.print(list.get(i) + " ");
        }

        reader.close();
        fileInputStream.close();
    }
}
