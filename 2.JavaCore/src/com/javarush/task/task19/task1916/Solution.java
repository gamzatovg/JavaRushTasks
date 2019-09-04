package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(reader.readLine()));

        reader.close();

        String currentString1 = fileReader1.readLine();
        String currentString2 = fileReader2.readLine();
        String nextString1 = fileReader1.readLine();
        String nextString2 = fileReader2.readLine();
        while (currentString1 != null || currentString2 != null) {
            if (Objects.equals(currentString1, currentString2)) {
                lines.add(new LineItem(Type.SAME, currentString1));

                currentString1 = nextString1;
                currentString2 = nextString2;
                nextString1 = fileReader1.readLine();
                nextString2 = fileReader2.readLine();
            } else if (Objects.equals(nextString1, currentString2)) {
                lines.add(new LineItem(Type.REMOVED, currentString1));

                currentString1 = nextString1;

                nextString1 = fileReader1.readLine();
            } else if (Objects.equals(nextString2, currentString1)) {
                lines.add(new LineItem(Type.ADDED, currentString2));

                currentString2 = nextString2;

                nextString2 = fileReader2.readLine();
            }
        }

        fileReader1.close();
        fileReader2.close();

        for (LineItem lineItem : lines) {
            System.out.println(String.format("%s %s", lineItem.type, lineItem.line));
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}