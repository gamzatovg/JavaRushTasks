package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human child1 = new Human("Child1", true, 21, new ArrayList<>());
        Human child2 = new Human("Child2", true, 11, new ArrayList<>());
        Human child3 = new Human("Child3", false, 1, new ArrayList<>());

        Human father = new Human("Father", true, 51, new ArrayList<>());
        Human mother = new Human("Mother", false, 41, new ArrayList<>());
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);

        Human grandFather1 = new Human("Grandfather1", true, 91, new ArrayList<>());
        Human grandMother1 = new Human("Grandmother1", false, 81, new ArrayList<>());
        Human grandFather2 = new Human("Grandfather2", true, 92, new ArrayList<>());
        Human grandMother2 = new Human("Grandmother2", false, 82, new ArrayList<>());
        grandFather1.children.add(mother);
        grandMother1.children.add(mother);
        grandFather2.children.add(father);
        grandMother2.children.add(father);

        HashSet<Human> family = new HashSet<Human>();
        Collections.addAll(family, child1, child2, child3, father, mother, grandFather1, grandMother1, grandFather2, grandMother2);

        for (Human member : family) {
            System.out.println(member);
        }
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
