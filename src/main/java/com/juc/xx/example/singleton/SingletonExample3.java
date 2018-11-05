package com.juc.xx.example.singleton;

import com.juc.xx.annoations.NotRecommend;
import com.juc.xx.annoations.NotThreadSafe;
import com.juc.xx.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造
    private SingletonExample3() {

    }
    //单例对象
    private static SingletonExample3 instance = null;

    //静态的工厂方法
    public static synchronized SingletonExample3 getInstanceInstance() {

        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }

}
