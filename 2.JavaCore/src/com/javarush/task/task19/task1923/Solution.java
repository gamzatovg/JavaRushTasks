package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        /*args = new String[]
                {"C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\file1.txt",
                        "C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\file2.txt"};
        */
        if (args.length != 2) {
            System.out.println("Illegal arguments");
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));

        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            String[] strings = bufferedReader.readLine().split(" ");

            for (String string : strings) if (string.matches("(.*)\\p{Digit}(.*)")) stringBuilder.append(string).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        bufferedWriter.write(stringBuilder.toString());

        bufferedWriter.close();
        bufferedReader.close();
    }
}
