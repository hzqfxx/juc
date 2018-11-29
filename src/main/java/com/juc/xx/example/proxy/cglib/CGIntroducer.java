package com.juc.xx.example.proxy.cglib;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.juc.xx.example.proxy.Person;

import sun.java2d.pipe.SpanIterator;

public class CGIntroducer implements MethodInterceptor{


    //获取被代理人信息
    public Object getInstance(Class target) throws Exception{
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(this);

        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //o被代理对象
        System.out.println("介绍(代理人)人开始工作");
        System.out.println("开始介绍人员");
        methodProxy.invokeSuper(o,objects);
        System.out.println("配对成功!");
        return null;
    }
}
