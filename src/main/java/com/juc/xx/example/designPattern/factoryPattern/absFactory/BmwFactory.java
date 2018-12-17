package com.juc.xx.example.designPattern.factoryPattern.absFactory;

import com.juc.xx.example.designPattern.factoryPattern.Bmw;
import com.juc.xx.example.designPattern.factoryPattern.Car;
import com.juc.xx.example.designPattern.factoryPattern.factoryMethod.Factory;

public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
