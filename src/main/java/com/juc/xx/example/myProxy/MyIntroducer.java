package com.juc.xx.example.myProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.juc.xx.example.proxy.Person;

public class MyIntroducer implements MyInvocationHandler{

    private Person target;
    //获取被代理人信息
    public Object getInstance(Person target) throws Exception{
        this.target=target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class为:" + clazz.getName());
        return MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("介绍(代理人)人开始工作");
        System.out.println("开始介绍人员");
        this.target.findLove();
        System.out.println("配对成功!");
        return null;
    }
}
