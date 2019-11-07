package com.shengsiyuan.jvm.classloader;

/**
 * 主动使用与被动使用.
 * 对于静态字段而言, 只有直接定义了该字段的类才会被初始化
 * 当一个类在初始化时,要求其父类全部都要先初始化完毕
 */
public class MyTest1 {
    public static void main(String[] args) {
        //MyParent1 static block
        //hello world
//        System.out.println(MyChild1.str);

        //MyParent1 static block
        //MyChild1 static block
        //welcome
        System.out.println(MyChild1.str2);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {

    public static String str2 = "welcome";

    static {
        System.out.println("MyChild1 static block");
    }
}
