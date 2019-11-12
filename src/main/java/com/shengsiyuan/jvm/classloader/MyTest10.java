package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
class Parent2 {
    static int a = 3;

    static{
        System.out.println("Parent2 static block");
    }
}

class Child2 extends Parent2 {
    static int b = 4;

    static {
        System.out.println("MyChild2 static block");
    }
}
public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        //MyTest10 static block
        //---------
        //Parent2 static block
        //---------
        //3
        //---------
        //MyChild2 static block
        //4

        // 这行代码仅仅是声明 没有对 Parent2 的主动使用, 因此无任何输出
        Parent2 parent2;
        System.out.println("---------");
        parent2 = new Parent2();
        System.out.println("---------");
        System.out.println(parent2.a);
        System.out.println("---------");
        System.out.println(Child2.b);
    }
}
