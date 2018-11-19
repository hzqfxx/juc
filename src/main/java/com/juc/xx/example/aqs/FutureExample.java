package com.juc.xx.example.aqs;

import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.tomcat.jni.Poll;
import org.springframework.boot.web.server.LocalServerPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureExample {
    static class FutureTest implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("do Something in Callable");
            Thread.sleep(5000);
            return "Done";

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> future = pool.submit(new FutureTest());
        System.out.println("do Something in Main");
        Thread.sleep(1000);
        String result = future.get();
        System.out.println("result:"+result);

    }

}

