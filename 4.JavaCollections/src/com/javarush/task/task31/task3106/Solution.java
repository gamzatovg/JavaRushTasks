package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.out.println("Первый аргумент - имя результирующего файла resultFileName,");
            System.out.println("остальные аргументы - имена файлов fileNamePart.");
            return;
        }

        String resultFileName = args[0];

        Arrays.sort(args, 1, args.length);
        
        List<FileInputStream> fileInputStreamLinkedList = new LinkedList<>();
        for (int i = 1; i < args.length; i++) {
            try {
                fileInputStreamLinkedList.add(new FileInputStream(args[i]));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreamLinkedList)));
             OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(resultFileName))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                int count;
                byte[] buffer = new byte[1024];
                while ((count = zipInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, count);
                }
                outputStream.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
