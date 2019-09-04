package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> files = new ArrayList<String>();
        Queue<File> folders = new LinkedList<File>();

        folders.add(new File(root));

        while (!folders.isEmpty()) {
            for (File file : folders.remove().listFiles()) {
                if (file.isDirectory()) {
                    folders.add(file);
                } else {
                    files.add(file.getAbsolutePath());
                }
            }
        }

        return files;
    }

    public static void main(String[] args) {
        
    }
}
