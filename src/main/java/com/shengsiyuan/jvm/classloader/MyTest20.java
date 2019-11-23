package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest20 {
    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        MyTest16_3 loader2 = new MyTest16_3("loader2");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        // true
        // 都是委托给系统类加载器加载
        System.out.println(clazz1 ==clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        // 可以运行
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1, object2);
    }
}
