package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;

    public Cat(String name) {
        this.name = name;
        age = 5;
        weight = 6;
        color = "white";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        color = "white";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        weight = 6;
        color = "white";
    }

    public Cat(int weight, String color) {
        age = 5;
        this.weight = weight;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        age = 5;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
