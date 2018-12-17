package com.juc.xx.example.designPattern.factoryPattern.absFactory;

import com.juc.xx.example.designPattern.factoryPattern.Car;

/**
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-17 14:36
 */
public class DefaultFactory extends AbstractFactory {

    private BenzFactory defaultFactory =new BenzFactory();

    @Override
    Car getCar() {
        return defaultFactory.getCar();
    }
}
