package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static void main(String[] args) {
        //Integer[] integers = {13, 8, 15, 5, 17};
        //Arrays.stream(sort(integers)).forEach(System.out::println);
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        double median = len % 2 == 0 ?
                (double) (array[len / 2 - 1] + array[len / 2]) / 2 :
                array[len / 2];
        Arrays.sort(array, Comparator.comparingDouble(i -> Math.abs(median - i)));

        return array;
    }
}
