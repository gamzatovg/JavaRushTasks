package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> yield = new HashSet<String>();
        Collections.addAll(yield,
                "арбуз",
                "банан",
                "вишня",
                "груша",
                "дыня",
                "ежевика",
                "женьшень",
                "земляника",
                "ирис",
                "картофель");

        Iterator<String> iterator = yield.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*
        System.out.println();
        for (String elem : yield) {
            System.out.println(elem);
        }*/
    }
}
