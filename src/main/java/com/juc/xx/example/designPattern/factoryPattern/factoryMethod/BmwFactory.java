package com.juc.xx.example.designPattern.factoryPattern.factoryMethod;

import com.juc.xx.example.designPattern.factoryPattern.Benz;
import com.juc.xx.example.designPattern.factoryPattern.Bmw;
import com.juc.xx.example.designPattern.factoryPattern.Car;

public class BmwFactory implements Factory {
    @Override
    public Car getCar() {
        return new Bmw();
    }
}
