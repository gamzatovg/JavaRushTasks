package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * The aim of the game is to eat 25 apples. Each eaten apple increases the snake's speed.
 *
 * Press the UP, RIGHT, DOWN, LEFT arrow keys to change the direction of snake movement
 * or the SPACE bar to restart the finished game.
 */
public class SnakeGame extends Game {
    public static final int WIDTH = 16;
    public static final int HEIGHT = 15;
    private int turnDelay;
    private Snake snake;
    private Apple apple;
    private int applesLeft;
    private boolean isGameStopped;
    private int score;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT + 1);
        createGame();
    }

    private void createGame() {
        turnDelay = 300;
        setTurnTimer(turnDelay);
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        createNewApple();
        applesLeft = 25;
        isGameStopped = false;
        score = 0;
        setScore(score);
        drawScene();
    }

    private void createNewApple() {
       Apple newApple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));

       if (snake.checkCollision(newApple))
           createNewApple();
       else
           apple = newApple;
    }

    private void drawScene() {
        for (int x = 0; x < WIDTH; x++)
            for (int y = 0; y < HEIGHT; y++)
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");

        for (int x = 0; x < WIDTH; x++)
            setCellValueEx(x, HEIGHT, Color.BLACK, "");

        setCellValueEx(WIDTH / 2 - 1, HEIGHT, Color.NONE, String.valueOf(applesLeft), Color.BLUE, 75);
        setCellValueEx(WIDTH / 2, HEIGHT, Color.NONE, "\uD83C\uDF4E", Color.GREEN, 75);

        apple.draw(this);
        snake.draw(this);
    }

    private void win() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "YOU WIN!", Color.WHITE, 75);
    }

    private void gameOver() {
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.NONE, "GAME OVER", Color.YELLOW, 75);
    }

    @Override
    public void onTurn(int step) {
        if (isGameStopped)
            return;

        snake.move(apple);

        if (!snake.isAlive)
            gameOver();

        if (!apple.isAlive) {
            score += 5;
            setScore(score);

            turnDelay -= 10;
            setTurnTimer(turnDelay);

            if (--applesLeft == 0)
                win();
            else
                createNewApple();
        }

        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case SPACE:
                if (isGameStopped)
                    createGame();
                break;
            //case ESCAPE:
            //    System.exit(0);
        }
    }
}
