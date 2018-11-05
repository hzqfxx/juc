package com.juc.xx.example.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.juc.xx.annoations.NotThreadSafe;

/**
 * 不可变对象
 * 使用ImmutableList集合 不能修改对象中的数据 配合final使用 引用也不可变
 */
@NotThreadSafe
public class ImmutableExample2 {

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3, 4);
    private static List<Integer> list2 = new ArrayList<Integer>();

    public static void main(String[] args) {
        list.add(2);
        //list=ImmutableList.of(1,2,3,4,5);
        list2.add(1);
        list2.add(2);
        Collections.unmodifiableList(list2);
        //list2.add(3);
        list2.forEach(System.out::println);
    }

}
