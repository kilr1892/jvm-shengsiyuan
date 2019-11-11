package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest5_1 {
    public static void main(String[] args) {
        System.out.println(MyChild5_2.b);
    }
}

class MyParent5_1 {
    // 如果 MyParent5_1 被初始化了, 静态变量 thread 一定会被赋值(就是初始化啦) ( 就是执行了等号右边的代码 )
    // 如果 MyParent5_1 为接口, 那么不会初始化, 即一个类在初始化时, 他所实现的接口是不会初始化的
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_1 invoked");
        }
    };
}

class MyChild5_1 extends MyParent5_1 {
//    public static int b = 5;
    public static final int b = 5;
}

class C {
    static {
        // 加上 static 只会在类加载的初始化阶段调用的
        System.out.println("hello c *static* block");
    }

    {
        // 不加 static 是一个实例化块, 每个对象被创建的时候,
        // 在构造方法之前, 实例化代码块都会被调用
        System.out.println("hello c block");
    }

    public C() {
        System.out.println("c");
    }
}