package com.juc.xx.example.designPattern.factoryPattern.factoryMethod;

import com.juc.xx.example.designPattern.factoryPattern.Benz;
import com.juc.xx.example.designPattern.factoryPattern.Car;

public class BenzFactory implements Factory {
    @Override
    public Car getCar() {
        return new Benz();
    }
}
