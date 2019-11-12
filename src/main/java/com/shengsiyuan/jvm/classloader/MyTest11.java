package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
class Parent3 {
    static int a = 3;

    static{
        System.out.println("Parent3 static block");
    }

    static void doSomething() {
        System.out.println("do something");
    }
}

class Child3 extends Parent3 {
    static int b = 4;

    static {
        System.out.println("MyChild3 static block");
    }

}
public class MyTest11 {
    public static void main(String[] args) {
        // 用子类去调用父类的静态变量, 实际上也只是对父类的主动使用
        System.out.println(Child3.a);
        System.out.println("----------------");
        Child3.doSomething();
    }
}
