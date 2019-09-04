package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File renamedFile = new File(resultFileAbsolutePath.getParent().concat("/allFilesContent.txt"));

        FileUtils.renameFile(resultFileAbsolutePath, renamedFile);

        Set<File> files = new TreeSet<File>((o1, o2) -> o1.getName().compareTo(o2.getName()));

        Queue<File> folders = new LinkedList<File>();
        folders.add(path);

        while (!folders.isEmpty()) {
            for (File file : folders.remove().listFiles()) {
                if (file.isDirectory()) {
                    folders.add(file);
                } else if (file.length() <= 50) {
                    files.add(file);
                }
            }
        }

        try (FileWriter fileWriter = new FileWriter(renamedFile)) {
            for (File file : files) {
                FileReader fileReader = new FileReader(file);
                while (fileReader.ready()) {
                    char[] buffer = new char[(int) file.length()];
                    int count = fileReader.read(buffer);
                    fileWriter.write(buffer, 0, count);
                    fileWriter.flush();
                }
                fileWriter.write("\n");
                fileReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
