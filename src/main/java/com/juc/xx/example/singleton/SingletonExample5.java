package com.juc.xx.example.singleton;


import java.util.HashMap;

import com.google.common.collect.Maps;
import com.juc.xx.annoations.Recommend;
import com.juc.xx.annoations.ThreadSafe;

/**
 * 枚举模式(推荐方式)
 */
@ThreadSafe
@Recommend
public class SingletonExample5 {

    //单例对象
    private static SingletonExample5 instance = null;

    //私有构造
    private SingletonExample5() {

    }

    private static SingletonExample5 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public enum Singleton {

        INSTANCE;

        private SingletonExample5 singleton;

        //jvm 保证这个方法只会调用一次,且在被使用前调用
        Singleton() {
            instance = new SingletonExample5();
        }

        public SingletonExample5 getInstance() {
            return singleton;
        }
    }

}
