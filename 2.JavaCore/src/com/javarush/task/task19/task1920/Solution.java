package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1920\\test.txt"};
        //
        if (args.length != 1) {
            System.out.println("Illegal argument");
            return;
        }

        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] strings = line.split("\\p{Space}");

            String name = strings[0];
            Double value = Double.parseDouble(strings[1]);

            treeMap.put(name, treeMap.containsKey(name) ? treeMap.get(name) + value : value);
        }

        double max = 0;
        for (Double d : treeMap.values()) if (d > max) max = d;

        for (String string : treeMap.keySet()) if (treeMap.get(string) == max) System.out.println(string);

        bufferedReader.close();
    }
}