package com.shengsiyuan.jvm.classloader;

import java.util.Random;

/**
 * 接口里的值都是常量
 * 一个接口在初始化时, 并不要求其父接口都完成了初始化(编译期可确定的值, 删除了 MyParent5 也可以正常执行  话说删除了 MyChild5 也可正常执行)
 * 只有在真正使用到父接口的时候 (如引用接口中所定义的常量时), 才会初始化
 */
public class MyTest5 {
    public static void main(String[] args) {
        System.out.println(MyChild5.b);

    }
}

interface MyParent5 {
//    public static int a = 5;
    public static int a = new Random().nextInt(2);
}

interface MyChild5 extends MyParent5 {
    // interface 默认是
    //    public static int b = 6;
//    public static final int b = new Random().nextInt(2);
//    public static final int b = 5;
//    public static final int b = new Random().nextInt(4);
    public static final int b = 5;
}
