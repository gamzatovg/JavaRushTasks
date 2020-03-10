package com.javarush.task.task35.task3509;

import java.util.*;


/* 
Collections & Generics
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>();

        for (T element : elements) {
            arrayList.add(element);
        }

        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>();

        for (T element : elements) {
            hashSet.add(element);
        }

        return hashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) throw new IllegalArgumentException();

        HashMap<K, V> hashMap = new HashMap<>();

        int i = 0;
        for (K key : keys) {
            hashMap.put(key, values.get(i++));
        }

        return hashMap;
    }
}
