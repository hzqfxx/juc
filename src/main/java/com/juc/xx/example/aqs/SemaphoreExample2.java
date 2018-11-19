package com.juc.xx.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量-获取多个许可
 */
public class SemaphoreExample2 {
    private  final static int ThreadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);
        for ( int i = 0; i < ThreadCount; i++) {
            final int ThreadNum=i;
            pool.execute(()->{
                try{
                    semaphore.acquire(3);
                    final String name = Thread.currentThread().getName();
                    test(ThreadNum,name);
                    semaphore.release(3);
                }catch (Exception e){
                    System.out.println( e);
                }

            });
        }
        pool.shutdown();
    }

    private static void test(int ThreadNum,String name) throws InterruptedException {
        System.out.println(ThreadNum+"===="+ name);
        Thread.sleep(1000);

    }
}
