package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human grandFarher1 = new Human("Деда1", true, 81);
        Human grandFather2 = new Human("Деда2", true, 82);
        Human grandMother1 = new Human("Бабка1", false, 71);
        Human grandMother2 = new Human("Бабка2", false, 72);
        Human father = new Human("Батя", true, 40, grandFarher1, grandMother1);
        Human mother = new Human("Мать", false, 35, grandFather2, grandMother2);
        Human child1 = new Human("Сын1", true, 15, father, mother);
        Human child2 = new Human("Сын2", true, 10, father, mother);
        Human child3 = new Human("Дочь", false, 5, father, mother);

        System.out.println(grandFarher1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















