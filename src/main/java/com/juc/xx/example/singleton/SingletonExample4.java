package com.juc.xx.example.singleton;

import com.juc.xx.annoations.ThreadSafe;

/**
 * 懒汉模式 双重检测模式
 */
@ThreadSafe
public class SingletonExample4 {

    //单例对象
    private static volatile SingletonExample4 instance = null;

    //私有构造
    private SingletonExample4() {

    }

    //静态的工厂方法
    public static SingletonExample4 getInstanceInstance() {

        //双重检测机制
        if (instance == null) {
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }

}
