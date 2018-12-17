package com.juc.xx.example.designPattern.factoryPattern.absFactory;

import com.juc.xx.example.designPattern.factoryPattern.Benz;
import com.juc.xx.example.designPattern.factoryPattern.Car;
import com.juc.xx.example.designPattern.factoryPattern.factoryMethod.Factory;

public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
