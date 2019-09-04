package com.javarush.task.task22.task2212;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) return false;

        int count = 0;
        for (Character ch : telNumber.toCharArray()) if (Character.isDigit(ch)) count++;

        if (count == 12 && telNumber.startsWith("+") || count == 10 && (telNumber.startsWith("(") || Character.isDigit(telNumber.charAt(0))))
            return telNumber.matches("(\\+\\d+)?(\\(\\d{3}\\))?\\d+-?\\d+-?\\d+$");

        return false;
    }

    public static void main(String[] args) {
        String pattern = "%s - %b";
        System.out.println();
        System.out.println(String.format(pattern, "+380501234567", checkTelNumber("+380501234567"))); // - true
        System.out.println(String.format(pattern, "+38(050)1234567", checkTelNumber("+38(050)1234567"))); // - true
        System.out.println(String.format(pattern, "+38050123-45-67", checkTelNumber("+38050123-45-67"))); // - true
        System.out.println(String.format(pattern, "050123-4567", checkTelNumber("050123-4567"))); // - true
        System.out.println(String.format(pattern, "+38)050(1234567", checkTelNumber("+38)050(1234567"))); // - false
        System.out.println(String.format(pattern, "+38(050)1-23-45-6-7", checkTelNumber("+38(050)1-23-45-6-7"))); // - false
        System.out.println(String.format(pattern, "050ххх4567", checkTelNumber("050ххх4567"))); // - false
        System.out.println(String.format(pattern, "050123456", checkTelNumber("050123456"))); // - false
        System.out.println(String.format(pattern, "(0)501234567", checkTelNumber("(0)501234567"))); // - false
    }
}
