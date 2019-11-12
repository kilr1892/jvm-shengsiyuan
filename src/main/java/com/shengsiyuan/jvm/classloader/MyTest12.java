package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
class CL {
    static {
        System.out.println("class CL");
    }
}

public class MyTest12 {
// 调用 ClassLoader 类的 loadClass 方法加载一个类, 并不是对类的主动使用, 不会导致类的初始化
    public static void main(String[] args) throws ClassNotFoundException {
        // 这个例子是为了说明静态代码块执行(也就是类的初始化)的时机
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        // 不导致初始化 应该只是加载而已
        Class<?> clazz = loader.loadClass("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);
        System.out.println("------------");
        // 初始化
        clazz = Class.forName("com.shengsiyuan.jvm.classloader.CL");
        System.out.println(clazz);

        //class com.shengsiyuan.jvm.classloader.CL
        //------------
        //class CL
        //class com.shengsiyuan.jvm.classloader.CL
    }
}
