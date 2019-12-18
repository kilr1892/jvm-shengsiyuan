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
public class MyTest26 {
    /*
    线程上下文加载器的一般使用模式 (获取 - 使用 - 还原)
    // 获取
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
        // 使用
        Thread.currentThread().setContextClassLoader(targetTccl);
        // myMethod()里面调用了Thread.currentThread().getContextClassLoader(), 获取当前设定好的线程上下文加载器做某些事情
        myMethod();
    } finally {
        // 还原
        Thread.currentThread().setContextClassLoader(classLoader);
    }

    如果一个类由类加载器A加载, 那么这个类的依赖类也是由相同的类加载器加载的 (如果该依赖类之前没有被加载过)

    ContextClassLoader的作用就是为了破坏java的类加载委托机制

    当高层提供了统一的接口让低层去实现, 同时又要在高层加载 (或实例化) 低层的类时, 就必须要通过线程上下文类加载器来帮助高层的ClassLoader找到并加载该类
    */

    public static void main(String[] args) {
        /*
        driver.getClass() = class com.mysql.jdbc.Driver, loader: sun.misc.Launcher$AppClassLoader@18b4aac2
        driver.getClass() = class com.mysql.fabric.jdbc.FabricMySQLDriver, loader: sun.misc.Launcher$AppClassLoader@18b4aac2
        当前线程上下文加载器: sun.misc.Launcher$AppClassLoader@18b4aac2
        ServiceLoader的类加载器: null
         */
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
