package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String name;
        private boolean sex;
        private int age;
        private int talent;
        private Human[] parents;
        private ArrayList<Human> society;

        public Human(String name, boolean sex, int age, int talent, Human[] parents, ArrayList<Human> society) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.talent = talent;
            this.parents = parents;
            this.society = society;
        }

        public Human() {
            new Human("Unknown", true, 30, 100, new Human[0], new ArrayList<Human>());
        }

        public Human(String name) {
            new Human(name, true, 30, 100, new Human[0], new ArrayList<Human>());
        }

        public Human(String name, boolean sex) {
            new Human(name, sex, 30, 100, new Human[0], new ArrayList<Human>());
        }

        public Human(String name, boolean sex, int age) {
            new Human(name, sex, age, 100, new Human[0], new ArrayList<Human>());
        }

        public Human(String name, boolean sex, int age, int talent) {
            new Human(name, sex, age, talent, new Human[0], new ArrayList<Human>());
        }

        public Human(String name, boolean sex, int age, int talent, Human[] parents) {
            new Human(name, sex, age, talent, parents, new ArrayList<Human>());
        }

        public Human(String name, boolean sex, int age, int talent, ArrayList<Human> society) {
            new Human(name, sex, age, talent, new Human[0], society);
        }

        public Human(boolean sex, int age) {
            new Human("Unknown", sex, age, 100, new Human[0], new ArrayList<Human>());
        }

        public Human(boolean sex) {
            new Human("Unknown", sex, 30, 100, new Human[0], new ArrayList<Human>());
        }
    }
}
