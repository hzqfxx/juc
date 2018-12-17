package com.juc.xx.example.designPattern.factoryPattern.absFactory;

/**
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-17 14:39
 */
public class Test {
    public static void main(String[] args) {
        DefaultFactory defaultFactory = new DefaultFactory();
        System.out.println(defaultFactory.getCar());
        System.out.println(defaultFactory.getCar("bmw"));
    }
}
