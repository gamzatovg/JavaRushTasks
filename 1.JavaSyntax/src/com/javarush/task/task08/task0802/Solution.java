package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> yield = new HashMap<String, String>();
        yield.put("арбуз", "ягода");
        yield.put("банан", "трава");
        yield.put("вишня", "ягода");
        yield.put("груша", "фрукт");
        yield.put("дыня", "овощ");
        yield.put("ежевика", "куст");
        yield.put("жень-шень", "корень");
        yield.put("земляника", "ягода");
        yield.put("ирис", "цветок");
        yield.put("картофель", "клубень");

        for (Map.Entry<String, String> pair : yield.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        /*
        System.out.println();
        Iterator<Map.Entry<String, String>> iterator = yield.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> pair = iterator.next();
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }*/
    }
}
