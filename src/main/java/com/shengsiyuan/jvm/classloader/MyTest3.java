package com.shengsiyuan.jvm.classloader;

import java.util.UUID;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest3 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3 {
    // 关键在于这个常量在编译时是否能知道
    // 当一个常量的值并非编译期间可以确定, 那么其值就不会放到调用类的常量池中
    // 这时在程序运行时, 会导致主动使用这个常量所在的类, 使得该类初始化
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent3 static code");
    }
}
