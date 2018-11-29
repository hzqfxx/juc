package com.juc.xx.example.myProxy;

import com.juc.xx.example.proxy.Person;
import com.juc.xx.example.proxy.SingleDog;

public class TestFindLove2 {

    public static void main(String[] args) throws Throwable {
        //new SingleDog().findLove();
        //代理模式
        try {
            Person instance =(Person) new MyIntroducer().getInstance(new SingleDog());
            System.out.println(instance.getClass().getName());
            instance.findLove();


            //获取字节码文件内容
          /*  byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
            FileOutputStream os = new FileOutputStream("E:/$Proxy0.class");
            os.write(data);
            os.close();*/


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
