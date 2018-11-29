package com.juc.xx.example.proxy;

import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;

public class TestFindLove {

    public static void main(String[] args) {
        //new SingleDog().findLove();
        //代理模式
        try {
            Person instance = (Person) new Introducer().getInstance(new SingleDog());
            System.out.println(instance.getClass().getName());
            //instance.findLove();

            /**
             * 原理
             * 1.拿到被代理对象的引用,获取其接口
             * 2.jdk代理重新生成一个类,同时实现被代理对象实现的接口.
             * 3.拿到被代理对象的引用
             * 4.重新动态生成一个class字节码
             * 5.编译
             */

            //获取字节码文件内容
            byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E:/$Proxy0.class");
            os.write(data);
            os.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
