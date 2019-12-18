package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest26_2 {

    public static void main(String[] args) {
        // 当前线程上下文加载器: sun.misc.Launcher$ExtClassLoader@1540e19d
        // ServiceLoader的类加载器: null
        // while不执行, 因为扩展类加载器不加载
//        Thread.currentThread().setContextClassLoader(MyTest26_2.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()) {
            Driver driver = iterator.next();
            System.out.println("driver.getClass() = " + driver.getClass() + ", loader: " + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文加载器: " + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器: " + ServiceLoader.class.getClassLoader());
    }
}
