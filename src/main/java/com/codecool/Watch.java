package com.codecool;

import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;

public class Watch implements Runnable {
    private static final int DELAY = 0;
    private static final int PERIOD = 1000;
    @Getter
    private int seconds = 0;
    @Getter
    private String name;
    @Getter
    private long thread_id;

    public Watch(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        thread_id = Thread.currentThread().getId() % 10 + 1;
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                seconds++;
            }
        }, DELAY, PERIOD);
    }
}
