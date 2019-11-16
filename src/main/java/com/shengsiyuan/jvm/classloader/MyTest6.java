package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest6 {
    public static void main(String[] args) {
        // 类的主动使用
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}
/*
 * 1. 连接时的准备阶段
 *    counter1=0 singleton = null  counter2=0
 * 2. 初始化阶段
 *    1.1 给 counter1 赋值 为3
 *    1.2 给 singleton 赋实例 执行了 构造方法
 *    1.3 给 counter2 赋值为0
 *
 * 上述描述可知, 连接是先从上到下把所有变量都准备完, 之后初始化也是从上到下执行完, 注意构造方法是 new 的时候引用的初始化
 */
class Singleton {
    public static int counter1 = 3;
    private static Singleton singleton = new Singleton();

    private Singleton() {
        // 这里的是初始化后的值
        counter1++;
        System.out.println("Singleton中的counter1: " + counter1);
        // 这里的 counter2 是类在连接时的准备阶段赋予的默认值
        counter2++;
        System.out.println("Singleton中的counter2: " + counter2);
    }

    // 这行代码的位置, 可以来理解类的初始化过程
    // 放在这里, 相当于代码执行到这里之后才进行了初始化 (是变量从上到下写的顺序来执行)
    public static int counter2 = 0;

    public static Singleton getInstance() {
        return singleton;
    }
}

