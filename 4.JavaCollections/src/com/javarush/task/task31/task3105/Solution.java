package com.javarush.task.task31.task3105;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 2) {
            System.out.println("Первый аргумент - полный путь к файлу fileName.");
            System.out.println("Второй аргумент - путь к zip-архиву.");
            return;
        }

        String fileName = args[0];
        String zipEntryName = "new/" + fileName.substring(fileName.lastIndexOf("/") + 1);
        String zip = args[1];

        HashMap<String, ByteArrayOutputStream> hashMap = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zip))) {
            ZipEntry zipEntry;
            String name;

            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                // получение названия файла
                name = zipEntry.getName();

                // распаковка
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int count;
                byte[] buffer = new byte[1024];
                while ((count = zipInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byteArrayOutputStream.flush();
                zipInputStream.closeEntry();

                // добавление в HashMap
                hashMap.put(name, byteArrayOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // удаление для замены (filename) в архиве если присутствует
        if (hashMap.containsKey(zipEntryName)) hashMap.remove(zipEntryName);

        // перепаковка архива
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zip))) {
            // сначала упакуем (fileName)
            zipOutputStream.putNextEntry(new ZipEntry(zipEntryName));
            Files.copy(Paths.get(fileName), zipOutputStream);
            zipOutputStream.closeEntry();

            // упаковываем все остальное
            for (Map.Entry<String, ByteArrayOutputStream> entry : hashMap.entrySet()) {
                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                zipOutputStream.write(entry.getValue().toByteArray());
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
