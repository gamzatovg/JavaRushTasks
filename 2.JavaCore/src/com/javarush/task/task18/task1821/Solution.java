package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) return;

        FileInputStream fileInputStream = new FileInputStream(args[0]);

        /*
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>(Comparator.comparingInt(i -> i));

        while (fileInputStream.available() > 0) {
            Integer key = fileInputStream.read();
            Integer count = treeMap.get(key);
            treeMap.put(key, count == null ? 1 : ++count);
        }

        Iterator iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(((char) entry.getKey()) + " " + entry.getValue());
        }
        */

        int[] count = new int[128];

        while (fileInputStream.available() > 0) {
            count[fileInputStream.read()]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) System.out.println((char) i + " " + count[i]);
        }

        fileInputStream.close();
    }
}
