package com.juc.xx.example.designPattern.factoryPattern.factoryMethod;

public class Test {
    public static void main(String[] args) {
        BenzFactory benzFactory = new BenzFactory();
        System.out.println( benzFactory.getCar().getName());

        BmwFactory bmwFactory = new BmwFactory();
        System.out.println( bmwFactory.getCar().getName());
    }
}
