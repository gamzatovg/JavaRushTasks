package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man1 = new Man("Man1", 25, "AddressOfMan1");
        Man man2 = new Man("Man2", 24, "AddressOfMan2");
        Woman woman1 = new Woman("Woman1", 23, "AddressOfWoman1");
        Woman woman2 = new Woman("Woman2", 22, "AddressOfWoman2");
        System.out.println(man1 + "\n" + man2 + "\n" + woman1 + "\n" + woman2);
    }

    //напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }

    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
