package com.juc.xx.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *synchronized 修饰-代码块  作用:当前对象
 *synchronized 修饰-方法    作用:当前对象
 *synchronized 修饰-静态方法  作用:所有对象
 *synchronized 修饰-类       作用:所有对象
 */
public class SynchronizedExample {

    //修饰代码块
    public void test(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("test =" +i+"=="+j);
            }
        }
    }

    //修饰方法
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test2 = " +i+"=="+j);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample synchronizedExample = new SynchronizedExample();
        SynchronizedExample synchronizedExample2 = new SynchronizedExample();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(()->{
            synchronizedExample.test(111);
        });
        pool.execute(()->{
            synchronizedExample2.test(333333);
        });
    }

}
