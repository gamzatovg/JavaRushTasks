package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(bufferedReader.readLine()));

        bufferedReader.close();

        boolean flag = false;
        while (fileReader.ready()) {
            String string = fileReader.readLine().replaceAll("\\.", "!");

            if (!flag) {
                fileWriter.write(string);
                flag = true;
            } else {
                fileWriter.write("\n".concat(string));
            }
        }

        fileWriter.close();
        fileReader.close();
    }
}
