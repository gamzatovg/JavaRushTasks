package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        for (String token : getTokens("level22.lesson13.task01", ".")) System.out.println(token);
    }
    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] tokens = new String[tokenizer.countTokens()];

        for (int i = 0; tokenizer.hasMoreTokens(); i++) tokens[i] = tokenizer.nextToken();

        return tokens;
    }
}
