package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */

/*
当前类加载器(Current Classloader)

每个类都会使用自己的类加载器(即加载自身的类加载器)来去加载其他类(指的是所依赖的类)
如果ClassX引用了ClassY,那么ClassX的类加载器就会去加载ClassY (前提是ClassY尚未被加载)

线程上下文类加载器(Context Classloader)

线程上下文类加载器是从JDK至1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader cl)
分别用来获取和设置上下文类加载器。
如果没有通过setContextClassLoader(ClassLoader cl)进行设置的话，线程将继承其父线程的上下文类加载器
Java应用运行时的初始线程的上下文类加载器是系统类加载器, 在线程中运行的代码可以通过该类加载器来加载类与资源

线程上下文类加载器的重要性

SPI(Service Provider Interface)
问题:
    只提供了接口, 具体实现由产商来实现, 由于父加载器无法加载子加载器所加载的类, 那么双亲委托机制无法解决该问题
解决方法:
    父ClassLoader可以使用当前线程Thread.currentThread().getContextLoader()所指定的classloader加载的类。
    这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载的类的情况，即改变了双亲委托模型。
    线程上下文类加载器就是当前线程的Current ClassLoader
总结:
    在双亲委托模型下，类加载是由下至上的，即下层的类加载器会委托上层进行加载。但是对于SPI来说，有些接口是Java核心库所提供的，
    而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自于不同的jar包(厂商提供)，，Java的启动类加载器是不会加载其他
    来源的jar包，这样传统的双亲委托模型就无法满足sPI的要求。而通过给当前线程设置上下文类加载器，就可以由设置的上下文类加载器
    来实现对于接口实现类的加载。

 */
public class MyTest24 {
    public static void main(String[] args) {
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(Thread.currentThread().getContextClassLoader());
        // null
        System.out.println(Thread.class.getClassLoader());

    }
}
