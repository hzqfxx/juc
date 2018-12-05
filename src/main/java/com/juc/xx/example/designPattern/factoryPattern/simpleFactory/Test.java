package com.juc.xx.example.designPattern.factoryPattern.simpleFactory;

import com.juc.xx.example.designPattern.factoryPattern.Car;
import com.juc.xx.example.designPattern.factoryPattern.Factory;

public class Test {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Car bmw = simpleFactory.getCar("benz");
        System.out.println(bmw.getName());
    }
}
