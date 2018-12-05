package com.juc.xx.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *synchronized 修饰-代码块  作用:当前对象
 *synchronized 修饰-方法    作用:当前对象
 *synchronized 修饰-静态方法  作用:所有对象
 *synchronized 修饰-类       作用:所有对象
 */
public class SynchronizedExample2 {

    //修饰类
    public void test(int j){
        synchronized (SynchronizedExample2.class){
            for (int i = 0; i < 10; i++) {
                System.out.println("Test =" +i+"=="+j);
            }
        }
    }

    //修饰方法
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test2 = " +i+"=="+j);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(()->{
            synchronizedExample.test(111);
        });
        pool.execute(()->{
            synchronizedExample2.test(222222);
        });
    }

}
