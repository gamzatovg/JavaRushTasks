package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] strings = fileScanner.nextLine().split(" ");

            String firstName = strings[1];
            String middleName = strings[2];
            String lastName = strings[0];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");

            Date birthDate = null;
            try {
                birthDate = simpleDateFormat.parse(strings[3].concat(strings[4]).concat(strings[5]));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
