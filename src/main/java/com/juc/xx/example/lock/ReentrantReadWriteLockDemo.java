package com.juc.xx.example.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantReadWriteLock 读写锁
 *其核心就是实现读写分离的锁,在高并发访问下,尤其是都多余写
 * 性能要远高于重入锁(因为sync和重入锁只能被一个线程访问其锁定的代码)
 * 本质分为2个锁,
 * 读锁:在读锁下,多个线程可以并发的进行访问
 * 写锁:在写锁下,多个线程只能一个个访问
 */
public class ReentrantReadWriteLockDemo {


    public static void main(String[] args) throws InterruptedException {
        final UsesReentrantReadWriteLock user = new UsesReentrantReadWriteLock();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            pool.execute(()->{
                user.method();
            });
        }


       /* Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                user.method();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                user.method2();
            }
        }, "t3");*/
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    user.method2();
                }
            }
        }, "t4");
        //Thread.sleep(10);
        //t2.start();
        //t3.start();
        t4.start();
        System.out.println("!23123123123123");
    }

}

class UsesReentrantReadWriteLock{

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private  ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private  ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private AtomicInteger count=new AtomicInteger(10);

    private Random random=new Random();

    public void method(){

        try{
            readLock.lock();
            System.out.println("线程"+Thread.currentThread().getName()+"读取锁,开始读取");
            Thread.sleep(1000*random.nextInt(5));
            System.out.println("线程"+Thread.currentThread().getName()+"读取锁,读取数据.....读取的数据为"+count.get());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
    public void method2(){

        try{
            writeLock.lock();
            int i = count.incrementAndGet();
            System.out.println("线程"+Thread.currentThread().getName()+"写锁,开始写入数据");
            Thread.sleep(1000*random.nextInt(5));
            System.out.println("线程"+Thread.currentThread().getName()+"写锁,写入数据..."+i);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

}



