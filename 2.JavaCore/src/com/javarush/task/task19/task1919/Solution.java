package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1919\\test.txt"};
        //
        if (args.length != 1) {
            System.out.println("Illegal argument");
            return;
        }

        String fileName = args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        TreeMap<String, Double> treeMap = new TreeMap<String, Double>();

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] strings = line.split("\\p{Space}");

            String name = strings[0];
            double value = Double.parseDouble(strings[1]);

            treeMap.put(name, treeMap.containsKey(name) ? treeMap.get(name) + value : value);
        }

        bufferedReader.close();

        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(String.format("%s %s", entry.getKey(), entry.getValue()));
        }
    }
}
