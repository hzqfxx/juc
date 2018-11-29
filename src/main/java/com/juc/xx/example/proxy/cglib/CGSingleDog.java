package com.juc.xx.example.proxy.cglib;


import com.juc.xx.example.proxy.Person;

public class CGSingleDog implements Person{

    private String sex="男";
    private String name="单身狗";

    //要求
    @Override
    public void findLove() {
        System.out.println("我是:"+this.name +"    性别为:" + this.sex+"     要求如下:");
        System.out.println("女的");
        System.out.println("活的");
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
