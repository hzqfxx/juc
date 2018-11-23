package com.juc.xx.example.deadLock;

import java.util.concurrent.Callable;

public class DeadLock implements Runnable{
        public int flag;
        private static Object o1 = new Object();
        private static Object o2 = new Object();

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"开始任务");
            if (flag==0){
                synchronized (o1){
                    System.out.println("线程"+Thread.currentThread().getName()+"获取o1");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2){
                        System.out.println("线程"+Thread.currentThread().getName()+"获取o2");
                    }
                }

            }
            if (flag==1){
                synchronized (o2){
                    System.out.println("线程"+Thread.currentThread().getName()+"获取o2");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o1){
                        System.out.println("线程"+Thread.currentThread().getName()+"获取o1");
                    }
                }

            }
        }

    public static void main(String[] args) {
        DeadLock threadTask = new DeadLock();
        DeadLock threadTask2 = new DeadLock();
        threadTask.flag=0;
        threadTask2.flag=1;
        new Thread(threadTask).start();
        new Thread(threadTask2).start();

    }



}
