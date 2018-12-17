package com.juc.xx.example.easypoi;

import java.util.Date;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-05 11:18
 */
public class Person {

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "性别", replace = {"男_1", "女_2"})
    private String sex;

    @Excel(name = "生日", format = "yyyy-MM-dd")
    private Date birthday;

    public Person(String name, String sex, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Person( ) {
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
