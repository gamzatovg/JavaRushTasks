package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    private static int countFolders = -1;
    private static int countFiles = 0;
    private static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bufferedReader.readLine());
        bufferedReader.close();

        if (!Files.isDirectory(path)) {
            System.out.println(path.toString() + " - не папка");
            return;
        }

        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                countFolders++;

                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                countFiles++;
                totalSize += Files.size(file);

                return super.visitFile(file, attrs);
            }
        });

        System.out.println("Всего папок - " + countFolders);
        System.out.println("Всего файлов - " + countFiles);
        System.out.println("Общий размер - " + totalSize);
    }
}
