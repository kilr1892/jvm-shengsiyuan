package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest22 {
    static{
        System.out.println("MyTest initializer");
    }

    public static void main(String[] args) {
        //MyTest initializer
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        //sun.misc.Launcher$ExtClassLoader@266474c2
        //java.ext.dirsF:\Java_Project\idea\jvm_lecture\build\classes\java\main
        System.out.println(MyTest22.class.getClassLoader());
        System.out.println(MyTest1.class.getClassLoader());
        System.out.println("java.ext.dirs" + System.getProperty("java.ext.dirs"));
    }
}
