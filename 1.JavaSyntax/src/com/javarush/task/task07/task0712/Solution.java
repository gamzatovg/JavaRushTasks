package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }

        int minLength = strings.get(0).length();
        int maxLength = minLength;
        for (String s : strings) {
            if (s.length() < minLength) {
                minLength = s.length();
            } else if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }

        for (String s : strings) {
            if (s.length() == minLength || s.length() == maxLength) {
                System.out.println(s);
                break;
            }
        }
    }
}
