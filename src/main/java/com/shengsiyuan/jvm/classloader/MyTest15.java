package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest15 {
    public static void main(String[] args) {
        String[] strings = new String[2];
        // null 表示启动类或根类加载器
        System.out.println(strings.getClass().getClassLoader());
        System.out.println("=====");
        MyTest15[] myTest15s = new MyTest15[2];
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(myTest15s.getClass().getClassLoader());
        System.out.println("=====");
        int[] ints = new int[2];
        // null 表示没有加载器
        System.out.println(ints.getClass().getClassLoader());
    }
}
