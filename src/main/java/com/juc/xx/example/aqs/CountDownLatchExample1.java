package com.juc.xx.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample1 {
    private  final static int ThreadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(ThreadCount);
        for (int i = 0; i < ThreadCount; i++) {
            final String name = Thread.currentThread().getName();
            final int ThreadNum=i;
            pool.execute(()->{
                try{
                    test(ThreadNum,name);
                }catch (Exception e){
                    System.out.println( e);
                }finally {
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        System.out.println("finish");
    }

    private static void test(int ThreadNum,String name) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(ThreadNum+"===="+ name);

    }
}
