package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest17 {
    public static void main(String[] args) throws Exception {
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        loader1.setPath();
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
