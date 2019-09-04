package com.javarush.task.task26.task2603;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

/*
Убежденному убеждать других не трудно
*/
public class Solution {
    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            return Arrays.stream(comparators)
                    .flatMap(comparator -> Stream.of(comparator.compare(o1, o2)))
                    .filter(i -> i != 0)
                    .findFirst()
                    .orElse(0);
        }
    }

    public static void main(String[] args) {
    }
}
