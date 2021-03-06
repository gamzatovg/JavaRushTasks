package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        //args = new String[]{"C:\\Users\\Gamzat\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1921\\input.txt"};
        //
        if (args.length != 1) {
            System.out.println("Illegal argument");
            return;
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] strings = line.split("\\p{Space}");
            int length = strings.length;

            int year = Integer.parseInt(strings[length - 1]);
            int month = Integer.parseInt(strings[length - 2]);
            int day = Integer.parseInt(strings[length - 3]);

            String name = line.replaceAll("\\p{Digit}", "").trim();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date birthday = simpleDateFormat.parse(String.format("%d %d %d", day, month, year));

            PEOPLE.add(new Person(name, birthday));
        }

        bufferedReader.close();
        /*
        for (Person person : PEOPLE) {
            System.out.println(String.format("%s %s", person.getName(), person.getBirthday().toString()));
        }
        */
    }
}
