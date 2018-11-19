package com.juc.xx.example.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量-获取超时时间内的许可
 */
public class SemaphoreExample3 {
    private  final static int ThreadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);
        for ( int i = 0; i < ThreadCount; i++) {
            final int ThreadNum=i;
            pool.execute(()->{
                try{
                    if ( semaphore.tryAcquire(1, TimeUnit.SECONDS)){
                        final String name = Thread.currentThread().getName();
                        test(ThreadNum,name);
                    }
                    semaphore.release();
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
