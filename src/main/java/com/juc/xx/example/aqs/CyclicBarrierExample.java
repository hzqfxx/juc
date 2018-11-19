package com.juc.xx.example.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CyclicBarrierExample {
    private static CyclicBarrier barrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService pool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            pool.execute(() -> {
                try {
                    test(threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

    }

    private static void test(int i) throws BrokenBarrierException, InterruptedException {
        Thread.sleep(1000);
        log.info("{} is ready", i);
        barrier.await();
        log.info("{} continue", i);

    }
}
