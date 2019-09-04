package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length == 0) return;

        switch (args[0]) {
            case "-c":
                create(args[1], args[2], new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[3]));
                return;
            case "-u":
                update(Integer.parseInt(args[1]), args[2], args[3], new SimpleDateFormat("dd/MM/y", Locale.ENGLISH).parse(args[4]));
                return;
            case "-d":
                delete(Integer.parseInt(args[1]));
                return;
            case "-i":
                System.out.println(info(Integer.parseInt(args[1])));
                return;
            default:
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
