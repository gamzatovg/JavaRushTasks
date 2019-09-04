package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()))
        ) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) stringBuilder.append(fileReader.readLine().concat(" "));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            String[] strings = stringBuilder.toString().split(" ");

            next:
            for (int i = 0; i < strings.length - 1; i++) {
                for (int j = i + 1; j < strings.length; j++) {
                    if (strings[i].equals("") || strings[j].equals("")) continue next;

                    if (strings[i].equals(new StringBuilder(strings[j]).reverse().toString())) {
                        Pair pair = new Pair();
                        pair.first = strings[i];
                        pair.second = strings[j];
                        result.add(pair);

                        strings[i] = "";
                        strings[j] = "";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Pair pair : result) System.out.println(pair);
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}
