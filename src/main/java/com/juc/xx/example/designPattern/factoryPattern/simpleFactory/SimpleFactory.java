package com.juc.xx.example.designPattern.factoryPattern.simpleFactory;

import com.juc.xx.example.designPattern.factoryPattern.Benz;
import com.juc.xx.example.designPattern.factoryPattern.Bmw;
import com.juc.xx.example.designPattern.factoryPattern.Car;
import com.juc.xx.example.designPattern.factoryPattern.Factory;

public class SimpleFactory implements Factory{

    @Override
    public Car getCar(String name) {
        if ("Benz".equalsIgnoreCase(name)){
            return  new Benz();
        }else if ("Bmw".equalsIgnoreCase(name)){
            return  new Bmw();
        }else {
            System.out.println("无法制造");
            return null;
        }
    }
}
