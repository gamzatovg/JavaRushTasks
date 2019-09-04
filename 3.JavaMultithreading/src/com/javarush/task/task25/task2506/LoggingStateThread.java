package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
        setDaemon(true);
    }

    @Override
    public void run() {
        State state = null;
        while (state != State.TERMINATED) if (state != target.getState()) System.out.println(state = target.getState());
    }
}
