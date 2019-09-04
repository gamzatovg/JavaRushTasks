package com.javarush.task.task12.task1216;

/* 
Летать охота
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add an interface here - добавь интерфейс тут
    public interface Fly {
        enum Direction {
            FORWARD, BACKWARD, UP, DOWN, RIGHT, LEFT
        }

        int speed = 0;

        enum Rotation {
            COUNTERCLOCKWISE, STOP, CLOCKWISE
        }

        void move(Direction direction, int speed);

        void rotate(Rotation horizontal, Rotation vertical);
    }
}
