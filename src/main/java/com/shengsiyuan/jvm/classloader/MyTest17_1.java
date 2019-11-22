package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        /*
        1. 未设置setPath方法, 自定义加载器也不知道去哪里加载
        2. 现在系统类加载器可以加载, 就加载了...
         */
        MyTest16 loader1 = new MyTest16("loader1");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        //clazz.hashCode() = 1956725890
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        //MySample is loded by: sun.misc.Launcher$AppClassLoader@18b4aac2
        //MyCat is loaded by: sun.misc.Launcher$AppClassLoader@18b4aac2
        /*
        这里是对其生成实例, 是主动使用
         */
        Object object = clazz.newInstance();
    }
}
