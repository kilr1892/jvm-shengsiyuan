package com.shengsiyuan.jvm.classloader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(classLoader);
        String resourceName = "com/shengsiyuan/jvm/classloader/MyTest13.class";

        Enumeration<URL> urls = classLoader.getResources(resourceName);

        while (urls.hasMoreElements()) {
            // file:/F:/Java_Project/idea/jvm_lecture/build/classes/java/main/com/shengsiyuan/jvm/classloader/MyTest13.class
            URL url = urls.nextElement();
            System.out.println(url);
        }
        System.out.println("=============");

        Class<?> clazz1 = MyTest14.class;
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(clazz1.getClassLoader());

        Class<?> clazz2 = String.class;
        // null
        System.out.println(clazz2.getClassLoader());
    }
}
