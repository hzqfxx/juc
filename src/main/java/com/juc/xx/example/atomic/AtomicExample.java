package com.juc.xx.example.atomic;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.StopWatch;

import com.juc.xx.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample {
    //请求总数
    public static Integer clientTotal = 5000;
    //并发线程数
    public static Integer threadTotal = 20;
    //计数器
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < clientTotal; i++) {
            list.add(i);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("==非并行");
        //线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            pool.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        pool.shutdown();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        log.info("========="+count+"=====");


    }

    private static void add(){
        count.incrementAndGet();
    }


}
