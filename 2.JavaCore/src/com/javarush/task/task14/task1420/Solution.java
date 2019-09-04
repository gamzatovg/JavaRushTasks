package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int num1 = Integer.valueOf(reader.readLine());
            if (num1 <= 0) throw new Exception();

            int num2 = Integer.valueOf(reader.readLine());
            if (num2 <= 0) throw new Exception();

            System.out.println(functionGcd(num1, num2));
        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }

    public static int functionGcd(int a, int b) {
        return b == 0 ? a : functionGcd(b, a % b);
    }
}
