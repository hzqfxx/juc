package com.juc.xx.example.immutable;

import java.util.Map;

import com.google.common.collect.Maps;
import com.juc.xx.annoations.NotThreadSafe;

/**
 * 不可变对象
 * 被final修饰的基本类型和String 不能改变
 * 被final修饰的引用对象 不能改变引用,但是可以修改对象中的数据
 */
@NotThreadSafe
public class ImmutableExample {
    private static final String a = "a";
    private static final Integer b = 1;
    private static final Map map = Maps.newHashMap();

    public static void main(String[] args) {
        //a="b";
        //b=2
        map.put(1,2);
        map.put(3,4);
        //map = Maps.newHashMap();
        map.forEach((k,v)->{
            System.out.print("key="+k+"     ");
            System.out.println("value="+v);
        });
    }

    private void test(int a) {

    }
}
