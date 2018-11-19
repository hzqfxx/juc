package com.juc.xx.example.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do Something in Callable");
                Thread.sleep(5000);
                return "Done";

            }
        });

        new Thread(futureTask).start();
        System.out.println("do Something in Main");
        Thread.sleep(1000);
        System.out.println("result:"+futureTask.get());
    }
}
