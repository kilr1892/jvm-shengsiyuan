package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest5_2 {
    public static void main(String[] args) {
//        System.out.println(MyChild5_2.b);
        System.out.println(MyParentInterface5_1.thread);
    }
}

class MyGrandpa5_2 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyGrandpa5_2 invoked");
        }
    };
}

class MyParent5_2 extends MyGrandpa5_2 {
    public static Thread thread = new Thread() {
        {
            System.out.println("MyParent5_2 invoked");
        }
    };
}

class MyChild5_2 extends MyParent5_2 {
    //    public static int b = 5;
    public static   int b = 5;
}

interface MyGrandpaInterface5_1 {
    public static final Thread thread = new Thread() {
        {
            System.out.println("interface MyGrandpa5_1 invoked");
        }
    };
}

interface MyParentInterface5_1 extends MyGrandpaInterface5_1 {
    public static final Thread thread = new Thread() {
        {
            System.out.println("interface MyParent5_1 invoked");
        }
    };
}