package com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App
{
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Watch> watches = new ArrayList<>();

        Watch watch0 = new Watch("Test0");
        Watch watch1 = new Watch("Test1");
        Watch watch2 = new Watch("Test2");
        watches.add(watch0);
        watches.add(watch1);
        watches.add(watch2);
        ListPrinter listPrinter = new ListPrinter(watches);

        executorService.execute(watch0);
        TimeUnit.SECONDS.sleep(5);
        executorService.execute(watch1);
        TimeUnit.SECONDS.sleep(5);
        executorService.execute(watch2);
        System.out.println("5 SECONDS!");
        TimeUnit.SECONDS.sleep(5);
        executorService.execute(listPrinter);




    }
}
