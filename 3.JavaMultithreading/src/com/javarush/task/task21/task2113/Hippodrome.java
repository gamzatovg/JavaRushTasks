package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100 ; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : getHorses()) horse.move();
    }

    public void print() {
        for (Horse horse : getHorses()) horse.print();
        for (int i = 0; i < 10; i++) System.out.println();
    }

    public Horse getWinner() {
        Horse winner = new Horse(null, 0, 0);

        for (Horse horse : getHorses()) if (horse.getDistance() > winner.getDistance()) winner = horse;

        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());

        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);

        Collections.addAll(game.getHorses(), horse1, horse2, horse3);

        game.run();
        game.printWinner();
    }
}
