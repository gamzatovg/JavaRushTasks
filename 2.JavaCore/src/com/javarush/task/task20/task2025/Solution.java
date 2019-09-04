package com.javarush.task.task20.task2025;

import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        List<Long> list = ArmstrongNumbersMultiSetLongOpt.generate(length(N));
        list.removeIf(num -> num >= N);
        long[] result = new long [list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);

        //System.out.println("\nThere are only " + list.size() + " Armstrong numbers smaller than " + N + ":");

        return result;
    }
    /*
    public static long[] getNumbers(long N) {
        if (N < 1L) return new long[0];

        TreeSet<Long> values = new TreeSet<>();

        long[][] degrees = calcDegrees(length(N) + 1);

        long num = 0;
        next:
        while (++num < N * 10) {
            int len = length(num);

            long temp = num;
            while (true) {
                byte lastDigit = (byte) (temp % 10L);
                temp /= 10L;
                if (temp == 0L) break;
                if ((byte) (temp % 10L) < lastDigit) continue next;
            }

            temp = num;
            long value = 0L;
            while (temp != 0L) {
                value += degrees[(int) (temp % 10L)][len];
                temp /= 10L;
            }

            if (len == length(value) && value < N) {
                temp = value;
                long valueSum = 0L;
                while (temp != 0L) {
                    valueSum += degrees[(int) (temp % 10L)][len];
                    temp /= 10L;
                }

                if (value == valueSum) values.add(value);
            }
        }

        long[] result = new long[values.size()];
        int index = 0;
        for (Long value : values) result[index++] = value;

        System.out.println("\nThere are only " + values.size() + " Armstrong numbers smaller than " + N + ":");

        return result;
    }
    */
    public static int length(long num) {
        long prod = 10L;

        for (int len = 1; len < 20; len++) {
            if (prod <= num) {
                prod *= 10L;
            } else {
                return len;
            }
        }

        return 20;
    }
    /*
    public static long[][] calcDegrees(int maxDegree) {
        long[][] degrees = new long[10][maxDegree + 1];

        for (int degree = 1; degree <= maxDegree; degree++) {
            for (long digit = 0L; digit < 10L; digit++) {
                if (degree == 1L) {
                    degrees[(int) digit][degree] = digit;
                } else {
                    degrees[(int) digit][degree] = degrees[(int) digit][degree - 1] * digit;
                }
            }
        }

        return degrees;
    }
    */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for (long armNum : getNumbers(Long.MAX_VALUE)) System.out.print(armNum + " ");

        long finalTime = System.currentTimeMillis();

        long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("\n\nTime consumed: " + (finalTime - startTime) / 1_000D + " seconds");
        System.out.println("Memory used: " + memory / 1_048_576 + " MB");
    }
}
