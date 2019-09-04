package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
    abstract void getRightCup(); //выбрать подходящую чашку

    abstract void putIngredient(); //положить ингредиенты

    abstract void pour(); //залить жидкостью

    /*
    Метод, который готовит напиток в такой последовательности:
        - выбирает чашку,
        - кладет ингредиенты,
        - заливает жидкостью.
    */
    void makeDrink() {
        getRightCup();

        putIngredient();

        pour();
    }


}
