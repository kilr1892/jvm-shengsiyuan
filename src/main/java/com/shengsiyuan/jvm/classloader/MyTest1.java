package com.shengsiyuan.jvm.classloader;

/**
 * 主动使用与被动使用.
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest1 {
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }
}

class MyParent1 {
    public static String str = "hello world";

    static {
        System.out.println("MyParent1 static block");
    }
}

class MyChild1 extends MyParent1 {
    static {
        System.out.println("MyChild1 static block");
    }
}
