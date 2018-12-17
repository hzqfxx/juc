package com.juc.xx.example.easypoi;

import java.io.File;
import java.util.List;

import org.apache.commons.collections4.SplitMapUtils;

import com.juc.xx.example.proxy.Person;

import ch.qos.logback.core.util.FileUtil;

/**
 * @Description:使用easyPoi进行导入 直接映射到对象
 * @author: xiaoxiang
 * @Date: 2018-12-05 9:30
 */
public class demo {
    public static void main(String[] args) {

      /*  String filePath = "E:\\整箱部.xls";
        System.out.println(filePath);
        File file = new File(filePath);
        System.out.println(file.exists());
        List<BoxInfo2> boxInfos = poiUtil.importExcel(filePath, 0, 1, BoxInfo2.class);
        System.out.println(boxInfos.size());
        boxInfos.stream().forEach(System.out::println);*/

       /* String filePath = "E:\\收退部.xls";
        System.out.println(filePath);
        File file = new File(filePath);
        System.out.println(file.exists());
        List<BoxInfo> boxInfos = poiUtil.importExcel(filePath, 0, 1, BoxInfo.class);
        System.out.println(boxInfos.size());
        boxInfos.stream().forEach(System.out::println);*/

        String filePath2 = "E:\\海贼王.xls";
        //解析excel，
        List<com.juc.xx.example.easypoi.Person> personList = poiUtil.importExcel(filePath2,1,1, com.juc.xx.example.easypoi.Person.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        personList.stream().forEach(System.out::println);
        System.out.println("导入数据一共【"+personList.size()+"】行");
    }
}
