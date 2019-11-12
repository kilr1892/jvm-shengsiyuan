package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
class Parent {
    static int a = 3;

    static {
        System.out.println("Parent static block");
    }
}

class Child extends Parent {
    static int b = 4;
    static {
        System.out.println("Child static block");
    }
}
public class MyTest9 {
    // 这段例子应该是说明静态代码块的执行是在方法之前
    // 静态代码块的性质
    // 它是随着类的加载而执行，只执行一次，并优先于主函数。
    // 具体说，静态代码块是由类调用的。类调用时，先执行静态代码块，然后才执行主函数的。
    // 静态代码块其实就是给类初始化的，而构造代码块是给对象初始化的。
    // 静态代码块中的变量是局部变量，与普通函数中的局部变量性质没有区别。
    // 一个类中可以有多个静态代码块
    // 静态代码块也是要主动使用才会执行
    static {
        System.out.println("MyTest9 static block");
    }
    public static void main(String[] args) {
        // MyTest9 static block
        // Parent static block
        // Child static block
        // 4
        System.out.println(Child.b);

    }
}
