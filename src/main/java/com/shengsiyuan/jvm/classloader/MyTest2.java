package com.shengsiyuan.jvm.classloader;

/**

 * @author RichardLee
 * @version v1.0
 */
public class MyTest2 {
    public static void main(String[] args) {
//        System.out.println(MyParent2.str);
//        System.out.println(MyParent2.s);
//        System.out.println(MyParent2.i);
        System.out.println(MyParent2.m);
    }
}
/*
 * 反编译命令
 * javap com.shengsiyuan.jvm.classloader.MyTest2
 * javap -c com.shengsiyuan.jvm.classloader.MyTest2
 *
 * 助记符:
 * ldc 表示将 int, float 或是 String 类型的常量值从常量池中推送至栈顶
 * bipush 表示将单字节 (-127-128) 的常量值推送至栈顶
 * sipush 表示将一个短整型常量值 (-32768-32767) 推送至栈顶
 * iconst_1 表示将 int 类型额数字1推送至栈顶 (最多就到 iconst_5)
 *
 */
class MyParent2 {
    // 加入 final 后 str 就是一个常量
    // 常量在编译阶段, 会存入到调用这个常量的方法所在类的常量池当中
    // 即 str 会放在 调用 str 的方法是 main, main 在 MyTest2 这个类中 ,
    // 因此 str 是放在 MyTest2 的常量池中

    // 本质上, 调用类并没有直接引用到定义常量的类, 因此并不会触发定义常量的类的初始化

    // 注意: 这里指的是将常量存放到了 MyTest2 的常量池中, 之后 MyTest2 是 MyParent2 就没有任何关系
    // 甚至, 我们可以将 MyParent2 的 class 文件删除

    public static final String str = "hello world";

    public static final short s = 7;

    public static final int i = 128;

    public static final int m = 1;

    static {
        System.out.println("MyParent2 static block");
    }
}
