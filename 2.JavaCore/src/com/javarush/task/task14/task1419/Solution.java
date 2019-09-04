package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        //2
        try {
            Object o = null;
            System.out.println(o.toString());
        } catch (Exception e) {
            exceptions.add(e);
        }

        //3
        try {
            int[] i = new int[0];
            i[0]++;
        } catch (Exception e) {
            exceptions.add(e);
        }

        //4
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //5
        try {
            throw new NumberFormatException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //6
        try {
            throw new NoSuchFieldException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //7
        try {
            throw new ArrayStoreException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //8
        try {
            throw new InstantiationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //9
        try {
            throw new IllegalAccessException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //10
        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }
    }
}
