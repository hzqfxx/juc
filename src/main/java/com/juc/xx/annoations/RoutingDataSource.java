package com.juc.xx.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.juc.xx.constants.DataSources;

/**
 * 标记 不推荐的写法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoutingDataSource {
    String value() default DataSources.MASTER_DB;
}
