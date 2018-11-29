package com.juc.xx.example.proxy.cglib;

import java.io.FileOutputStream;

import com.juc.xx.example.proxy.Introducer;
import com.juc.xx.example.proxy.Person;
import com.juc.xx.example.proxy.SingleDog;

import sun.misc.ProxyGenerator;

public class CGFindLove {

    public static void main(String[] args) {
        //new SingleDog().findLove();
        //代理模式
        try {
            CGSingleDog instance = (CGSingleDog)new CGIntroducer().getInstance(CGSingleDog.class);
            instance.findLove();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
