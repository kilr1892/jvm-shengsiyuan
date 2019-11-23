package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest18_1 {

    public static void main(String[] args) throws ClassNotFoundException {
        MyTest16_3 loader1 = new MyTest16_3("loader1");

        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");

        System.out.println("class: " + clazz.hashCode());
        System.out.println("class loader: " + clazz.getClassLoader());
    }
}
