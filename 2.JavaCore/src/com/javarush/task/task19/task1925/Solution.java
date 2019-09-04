package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*args = new String[]
                {"C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\file1.txt",
                        "C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\file2.txt"};
        */
        if (args.length != 2) {
            System.out.println("Illegal arguments");
            return;
        }

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(args[1]));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedFileReader.ready()) {
            String[] strings = bufferedFileReader.readLine().split(" ");

            for (String string : strings) if (string.length() > 6) stringBuilder.append(string.concat(","));
        }
        bufferedFileWriter.write(stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString());

        bufferedFileWriter.close();
        bufferedFileReader.close();
    }
}
