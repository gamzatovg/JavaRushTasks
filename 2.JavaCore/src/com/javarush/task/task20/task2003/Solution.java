package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (FileInputStream fis = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())) {
            load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();

        Solution.properties.forEach(properties::setProperty);

        properties.store(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties properties = new Properties();

        properties.load(inputStream);

        Solution.properties.clear();

        properties.forEach((key, value) -> Solution.properties.put(key.toString(), value.toString()));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.fillInPropertiesMap();
    }
}