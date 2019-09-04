package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length == 0) return;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int i = 0;
                    while (i < args.length - 1) {
                        create(args[++i], args[++i], new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[++i]));
                    }
                }
                return;
            case "-u":
                synchronized (allPeople) {
                    int i = 0;
                    while (i < args.length - 1) {
                        update(Integer.parseInt(args[++i]), args[++i], args[++i], new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[++i]));
                    }
                }
                return;
            case "-d":
                synchronized (allPeople) {
                    int i = 0;
                    while (i < args.length - 1) {
                        delete(Integer.parseInt(args[++i]));
                    }
                }
                return;
            case "-i":
                synchronized (allPeople) {
                    int i = 0;
                    while (i < args.length - 1) {
                        System.out.println(info(Integer.parseInt(args[++i])));
                    }
                }
                return;
        }
    }

    public static void create(String name, String sex, Date bd) {
        allPeople.add(sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd));
        System.out.println(allPeople.size() - 1);
    }

    public static void update(int id, String name, String sex, Date bd) {
        allPeople.set(id, sex.equals("м") ? Person.createMale(name, bd) : Person.createFemale(name, bd));
    }

    public static void delete(int id) {
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDay(null);
    }

    public static String info(int id) {
        Person person = allPeople.get(id);
        Sex sex = person.getSex();
        String s = null;

        if (sex == Sex.MALE ) {
            s = "м";
        } else if (sex == Sex.FEMALE) {
            s = "ж";
        }

        return person.getName() + " " + s + " " + new SimpleDateFormat("dd-MMM-y", Locale.ENGLISH).format(person.getBirthDay());
    }
}
