package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        if (args.length == 0) return;

        switch (args[0]) {
            case "-u":
                toDo(Mode.UPDATE, args);
                break;
            case "-d":
                toDo(Mode.DELETE, args);
                break;
        }
    }

    public static void toDo(Mode mode, String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();

            reader.close();

            StringBuilder stringBuilder = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            int id = Integer.parseInt(args[1].trim());

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();

                int currentId = Integer.parseInt(line.substring(0, 8).trim());

                if (currentId == id) {
                    if (mode == Mode.UPDATE) {
                        int length;

                        StringBuilder resultId = new StringBuilder(args[1].trim());
                        length = 8 - resultId.length();
                        for (int i = 0; i < length; i++) resultId.append(" ");

                        StringBuilder productName = new StringBuilder(args[2].trim());
                        length = 30 - productName.length();
                        for (int i = 0; i < length; i++) productName.append(" ");

                        StringBuilder price = new StringBuilder(args[3].trim());
                        length = 8 - price.length();
                        for (int i = 0; i < length; i++) price.append(" ");

                        StringBuilder quantity = new StringBuilder(args[4].trim());
                        length = 4 - quantity.length();
                        for (int i = 0; i < length; i++) quantity.append(" ");

                        stringBuilder.append(resultId).append(productName).append(price).append(quantity).append("\n");
                    } else if (mode == Mode.DELETE);
                } else {
                    stringBuilder.append(line.concat("\n"));
                }
            }

            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            bufferedReader.close();

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));

            bufferedWriter.write(stringBuilder.toString());

            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
