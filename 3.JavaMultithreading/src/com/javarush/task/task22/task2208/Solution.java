package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();

        params.forEach((key, value) -> {
            if (value != null)
                if (stringBuilder.length() == 0)
                    stringBuilder.append(String.format("%s = \'%s\'", key, value));
                else
                    stringBuilder.append(String.format(" and %s = \'%s\'", key, value));
        });

        return stringBuilder.toString();
    }
}
