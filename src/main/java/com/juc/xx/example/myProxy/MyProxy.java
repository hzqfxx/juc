package com.juc.xx.example.myProxy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

//生成代理对象的代码
public class MyProxy {

    private static String ln = "\r\n";

    @SuppressWarnings("a")
    public static Object newProxyInstance(MyClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h) throws IllegalArgumentException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            //1.生成原代码
            String proxySrc = generateSrc(interfaces[0]);
            //2.将生成的代码输出到磁盘,保存为.java文件
            String path = MyProxy.class.getResource("").getPath();
            System.out.println("路径:" + path);
            File file = new File(path + "$Proxy0.java");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(proxySrc);
            fileWriter.flush();
            fileWriter.close();
            //3.编译源码,生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = standardFileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, null, null, iterable);
            task.call();
            standardFileManager.close();
            //4.将class文件中的内容动态加载到jvm中
            //5.返回被代理后的代理对象
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);
            //file.delete();
            return constructor.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer("package com.juc.xx.example.myProxy;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        //public final class $Proxy0 extends Proxy implements Person {
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);

        src.append("MyInvocationHandler h ;" + ln);

        src.append("public $Proxy0(MyInvocationHandler h){" + ln);
        src.append("this.h = h;" + ln);
        src.append("}" + ln);

        for (Method method : interfaces.getMethods()) {
            src.append("public " + method.getReturnType().getName() + " " + method.getName() + "() throws Throwable {" + ln);
            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);

            src.append("}catch(Exception e){}" + ln);
            src.append("}" + ln);
        }

        src.append("}");
        return src.toString();
    }
}
