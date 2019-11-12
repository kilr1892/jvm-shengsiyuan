package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("java.lang.String");
        // null
         System.out.println(clazz.getClassLoader());
        Class<?> clazz2 = Class.forName("com.shengsiyuan.jvm.classloader.C_1");
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // 这是应用类加载器 (系统类加载器)
        System.out.println(clazz2.getClassLoader());
    }
}

class C_1 {

}

