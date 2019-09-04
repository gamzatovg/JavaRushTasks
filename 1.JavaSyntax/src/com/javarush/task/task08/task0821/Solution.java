package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Фамлия", "Имя");
        map.put("Фамлия", "Имя");
        map.put("Фамлия3", "Имя3");
        map.put("Фамлия4", "Имя4");
        map.put("Фамлия5", "Имя5");
        map.put("Фамлия6", "Имя6");
        map.put("Фамлия7", "Имя");
        map.put("Фамлия", "Имя");
        map.put("Фамлия", "Имя9");
        map.put("Фамлия", "Имя");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
