package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length != 4 || !args[0].equals("-c")) {
            System.out.println("Invalid arguments");
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        reader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        int maxId = 0;

        while (fileReader.ready()) {
            String line = fileReader.readLine();

            int currentId = Integer.parseInt(line.substring(0, 8).trim());

            if (currentId > maxId) maxId = currentId;
        }

        fileReader.close();

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));

        int length;

        StringBuilder resultId = new StringBuilder(String.valueOf(++maxId));
        length = 8 - resultId.length();
        for (int i = 0; i < length; i++) resultId.append(" ");

        StringBuilder productName = new StringBuilder(args[1]);
        length = 30 - productName.length();
        for (int i = 0; i < length; i++) productName.append(" ");

        StringBuilder price = new StringBuilder(args[2]);
        length = 8 - price.length();
        for (int i = 0; i < length; i++) price.append(" ");

        StringBuilder quantity = new StringBuilder(args[3]);
        length = 4 - quantity.length();
        for (int i = 0; i < length; i++) quantity.append(" ");

        StringBuilder resultLine = new StringBuilder("\n").append(resultId).append(productName).append(price).append(quantity);

        fileWriter.write(resultLine.toString());

        fileWriter.close();
    }
}
