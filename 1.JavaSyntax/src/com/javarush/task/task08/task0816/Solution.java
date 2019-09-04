package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Stallone1", df.parse("JULY 1 1981"));
        map.put("Stallone2", df.parse("AUGUST 1 1982"));
        map.put("Stallone3", df.parse("SEPTEMBER 1 1983"));
        map.put("Stallone4", df.parse("OCTOBER 1 1984"));
        map.put("Stallone5", df.parse("NOVEMBER 1 1985"));
        map.put("Stallone6", df.parse("DECEMBER 1 1986"));
        map.put("Stallone7", df.parse("JANUARY 1 1987"));
        map.put("Stallone8", df.parse("FEBRUARY 1 1988"));
        map.put("Stallone9", df.parse("MARCH 1 1989"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth();
            if (month >= 5 && month <= 7) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
