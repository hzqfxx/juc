package com.juc.xx.example.singleton;

import com.juc.xx.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExample {

    //私有构造
    private SingletonExample() {

    }
    //单例对象
    private static SingletonExample instance = null;

    //静态的工厂方法
    public static SingletonExample getInstanceInstance() {

        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }

}
