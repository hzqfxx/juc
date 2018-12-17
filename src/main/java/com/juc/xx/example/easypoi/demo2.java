package com.juc.xx.example.easypoi;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.validation.Valid;

/**
 * @Description:
 * @author: xiaoxiang
 * @Date: 2018-12-05 15:19
 */
public class demo2 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("1");
        person.setSex("11");
        Person person2 = new Person();
        person2.setName("2");
        Arrays.asList(person,person2).stream().collect(Collectors.groupingBy(Person::getName)).forEach((k, v)-> System.out.println(k+"value = " +v));
        Arrays.asList(person,person2).stream().collect(Collectors.groupingBy(Person::getSex)).forEach((k, v)-> System.out.println(k+"value = " +v));

    }
}
