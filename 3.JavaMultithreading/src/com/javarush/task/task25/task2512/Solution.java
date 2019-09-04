package com.javarush.task.task25.task2512;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        Deque<Throwable> throwables = new ArrayDeque<>();
        while (e != null) {
            throwables.push(e);
            e = e.getCause();
        }
        throwables.forEach(System.out::println);
    }

    public static void main(String[] args) {
    }
}
