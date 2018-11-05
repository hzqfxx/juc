package com.juc.xx.example.singleton;

import com.juc.xx.annoations.NotThreadSafe;
import com.juc.xx.annoations.ThreadSafe;

/**
 * 恶汉模式
 */
@ThreadSafe
public class SingletonExample2 {

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //私有构造
    private SingletonExample2() {

    };

    //静态的工厂方法
    public static SingletonExample2 getInstanceInstance() {
        return instance;
    }

}
