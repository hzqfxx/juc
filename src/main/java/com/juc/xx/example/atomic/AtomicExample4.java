package com.juc.xx.example.atomic;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

import com.juc.xx.annoations.ThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ThreadSafe
public class AtomicExample4 {
    //计数器
    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        AtomicReference<Integer> reference = new AtomicReference<>(count);
        reference.compareAndSet(0,10);
        reference.compareAndSet(1,5);
        reference.compareAndSet(10,20);
        reference.compareAndSet(5,10);
        reference.compareAndSet(7,8);
        log.info("=============="+reference.get());
    }



}
