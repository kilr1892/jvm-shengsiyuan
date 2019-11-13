package com.shengsiyuan.jvm.classloader;

/**
 * 验证下三层classLoader.
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest13 {
    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);

        while (classLoader != null) {
            // sun.misc.Launcher$ExtClassLoader@4554617c
            // null
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }

    }
}
