package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String currentFileName, destinationFileName = null;

        TreeSet<String> treeSet = new TreeSet<String>((String s1, String s2) ->
                Integer.compare(
                        Integer.parseInt(s1.substring(s1.lastIndexOf(".") + 5)),
                        Integer.parseInt(s2.substring(s2.lastIndexOf(".") + 5))
                )
        );

        while (!(currentFileName = reader.readLine()).equals("end")) {
            if (destinationFileName == null) destinationFileName = currentFileName.substring(0, currentFileName.lastIndexOf("."));

            treeSet.add(currentFileName);
        }

        reader.close();

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFileName));

        for (String fileName : treeSet) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

            while (bufferedInputStream.available() > 0) bufferedOutputStream.write(bufferedInputStream.read());

            bufferedInputStream.close();
        }

        bufferedOutputStream.close();
    }
}
