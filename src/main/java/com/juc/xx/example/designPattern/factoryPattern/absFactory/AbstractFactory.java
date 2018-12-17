package com.juc.xx.example.designPattern.factoryPattern.absFactory;

import com.juc.xx.example.designPattern.factoryPattern.Car;

/**
 * 抽象工厂模式
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-17 14:32
 */
public abstract class AbstractFactory {

    abstract Car getCar();

    public Car getCar(String name) {
        if ("Benz".equalsIgnoreCase(name)){
            return  new BenzFactory().getCar();
        }else if ("Bmw".equalsIgnoreCase(name)){
            return  new BmwFactory().getCar();
        }else {
            System.out.println("无法制造");
            return null;
        }
    }


}
