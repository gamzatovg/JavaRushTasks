package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        ArrayList<Month> months = new ArrayList<>();
        Collections.addAll(months, Month.values());

        int i = 0;
        for(Month month : months) {
            i++;
            if (month.toString().equals(str.toUpperCase())) {
                System.out.println(str + " is the " + i + " month");
            }
        }
    }
}
