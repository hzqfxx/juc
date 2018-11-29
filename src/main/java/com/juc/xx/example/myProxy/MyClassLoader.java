package com.juc.xx.example.myProxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// 代码的生成,编译,重新动态加载到JVM中
public class MyClassLoader extends ClassLoader {
    private File baseDir;

    public MyClassLoader() {
        String path = MyClassLoader.class.getResource("").getPath();
        this.baseDir = new File(path);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //获得代理对象的包名+类名(加载使用)
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if (baseDir != null) {
            //获取到文件地址
            File fileClass = new File(baseDir, name.replaceAll("\\.", "/") + ".class");
            if (fileClass.exists()) {
                //如果文件存在,加载到jvm中
                FileInputStream in = null;
                try {
                    in = new FileInputStream(fileClass);
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len=in.read(buff))!=-1){
                        outputStream.write(buff,0,len);
                    }
                        return defineClass(className,outputStream.toByteArray(),0,outputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        in.close();
                        fileClass.delete();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return null;
    }
}
