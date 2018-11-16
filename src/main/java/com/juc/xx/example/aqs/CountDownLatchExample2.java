package com.juc.xx.example.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {
    private  final static int ThreadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(ThreadCount);
        for (int i = 0; i < ThreadCount; i++) {

            final int ThreadNum=i;
            pool.execute(()->{
                final String name = Thread.currentThread().getName();
                try{
                    test(ThreadNum,name);
                }catch (Exception e){
                    System.out.println( e);
                }finally {
                    countDownLatch.countDown();
                }

            });
        }
        //超过时间不予等待,直接执行后面操作(但后面的还是回执行完成)
        countDownLatch.await(1, TimeUnit.MILLISECONDS);
        System.out.println("finish");
    }

    private static void test(int ThreadNum,String name) throws InterruptedException {
        System.out.println(ThreadNum+"===="+ name);

    }
}
