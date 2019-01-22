package com.codecool;

import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;

public class Watch implements Runnable {
    private static final int DELAY = 0;
    private static final int PERIOD = 1000;
    @Getter
    private volatile int seconds = 0;
    @Getter
    private String name;
    @Getter
    private long thread_id;
    @Getter
    private volatile boolean isInterrupted;

    public Watch(String name) {
        this.name = name;
        this.isInterrupted = false;
    }

    @Override
    public void run() {
        thread_id = Thread.currentThread().getId() % 10 + 1;
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (isInterrupted) this.cancel();
                seconds++;
            }
        }, DELAY, PERIOD);
    }

    public void interrupt() {
        this.isInterrupted = true;
    }
}
