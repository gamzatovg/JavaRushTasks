package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    private Direction direction = Direction.LEFT;
    public boolean isAlive = true;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.LEFT || this.direction == Direction.RIGHT) && snakeParts.get(0).x == snakeParts.get(1).x)
            return;
        if ((this.direction == Direction.UP || this.direction == Direction.DOWN) && snakeParts.get(0).y == snakeParts.get(1).y)
            return;
        
        switch (direction) {
            case UP:
                if (this.direction != Direction.DOWN)
                    this.direction = direction;
                break;
            case RIGHT:
                if (this.direction != Direction.LEFT)
                    this.direction = direction;
                break;
            case DOWN:
                if (this.direction != Direction.UP)
                    this.direction = direction;
                break;
            case LEFT:
                if (this.direction != Direction.RIGHT)
                    this.direction = direction;
                break;
        }
    }

    public int getLength() {
        return snakeParts.size();
    }

    public void draw(Game game) {
        //head
        GameObject snakePart = snakeParts.get(0);
        game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, HEAD_SIGN, isAlive ? Color.BLACK : Color.RED, 75);

        //body
        for (int i = 1; i < snakeParts.size(); i++) {
            snakePart = snakeParts.get(i);
            game.setCellValueEx(snakePart.x, snakePart.y, Color.NONE, BODY_SIGN, isAlive ? Color.BLACK : Color.RED, 75);
        }
    }

    public void move(Apple apple) {
        GameObject newHead = createNewHead();

        if (checkCollision(newHead) || newHead.x < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT) {
            isAlive = false;
            return;
        }

        snakeParts.add(0, newHead);

        if (newHead.x == apple.x && newHead.y == apple.y)
            apple.isAlive = false;
        else
            removeTail();

    }

    public GameObject createNewHead() {
        GameObject head = snakeParts.get(0);

        switch (direction) {
            case UP:
                head = new GameObject(head.x, head.y - 1);
                break;
            case RIGHT:
                head = new GameObject(head.x + 1, head.y);
                break;
            case DOWN:
                head = new GameObject(head.x, head.y + 1);
                break;
            case LEFT:
                head = new GameObject(head.x - 1, head.y);
                break;
        }

        return head;
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }

    public boolean checkCollision(GameObject gameObject) {
        for (GameObject snakePart : snakeParts)
            if (snakePart.x == gameObject.x && snakePart.y == gameObject.y)
                return true;

        return false;
    }
}
