package com.codecool;

import java.util.List;

public class ListPrinter implements Runnable {

    private List<Watch> watchList;

    public ListPrinter(List<Watch> watchList) {
        this.watchList = watchList;
    }
    @Override
    public void run() {
        for (Watch watch : watchList) {
            System.out.println("Thread id: " + watch.getThread_id());
            System.out.println("Watch name: " + watch.getName());
            System.out.println("Watch run-time: " + watch.getSeconds() + " seconds");
            System.out.println("Is interrupted: " + watch.isInterrupted());
            System.out.println("--------------------------------------------------");
        }
    }
}
