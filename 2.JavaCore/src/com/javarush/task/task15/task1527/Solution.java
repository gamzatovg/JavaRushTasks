package com.javarush.task.task15.task1527;

import javax.swing.text.html.HTMLDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String line = reader.readLine();

            line = line.substring(line.indexOf("?") + 1);

            List<String> keys = Arrays.asList(line.split("&"));

            int i = -1;

            for (String key: keys) {
                if (key.contains("obj")) i = keys.indexOf(key);

                System.out.print(key.split("=")[0] + " ");
            }

            System.out.println();

            if (i != -1) {
                String value = keys.get(i).split("=")[1];

                try {
                    alert(Double.parseDouble(value));
                } catch (Exception e) {
                    alert(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
