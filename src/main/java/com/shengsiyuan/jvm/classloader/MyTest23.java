package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest23 {
    public static void main(String[] args) {
        // 在运行期, 一个java类是由该类的完全限定名(binary name, 二进制名) 和用于加载该类的定义类加载器(defining loader) 所共同决定的
        // 如果同样名字(即相同的完全限定名)的类是由两个不同的类加载器所加载, name这些类是不同的, 即使.class文件的字节码完全一样, 并且从
        // 相同的位置加载亦如此

        // sun.boot.class.path 配置路径不可改, 改了后会报错jvm初始化错误

        // 內建于JVM中的启动类加载器会加载java. lang.ClassLoader以及其他的Java平台类,
        // 当JVM启动时，一块特殊的机器码会运行，它会加载扩展类加载器与系统类加载器,
        // 这块特殊的机器码叫做启动类加载器(Bootstrap) 。
        // 启动类加载器并不是Java类，而其他的加载器则都是Java类，
        // 启动类加载器是特定于平台的机器指令，它负责开启整个加载过程。
        // 所有类加载器(除了启动类加载器)都被实现为Java类。 不过，总归要有一个组件 来加载第一个Java类加载器， 从而让整个加载过程能够顺利
        // 进行下去，加载第一个纯Java类加载器就是启动类加载器的职责。
        // 启动类加载器还会负责加载供JRE正常运行所需要的基本组件，这包括java . util与java. lang包中的类等等。
//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));

//        System.out.println(ClassLoader.class.getClassLoader());

        // 扩展类加载器与系统类加载器也是由启动类加载器所加载的
//        System.out.println(Launcher.class.getClassLoader());
        System.out.println("----------------------");



        // java -Djava.system.class.loader=com.shengsiyuan.jvm.classloader.MyTest16_4 com.shengsiyuan.jvm.classloader.MyTest23
        // 并修改MyTest16_4 , 增加
        //  public MyTest16_4(ClassLoader parent) {
        //      super(parent);
        //  }

        // com.shengsiyuan.jvm.classloader.MyTest16_4
        System.out.println(System.getProperty("java.system.class.loader"));
        // jdk.internal.loader.ClassLoaders$AppClassLoader@6659c656
        System.out.println(MyTest23.class.getClassLoader());
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(MyTest16_4.class.getClassLoader());
        // ide 运行: sun.misc.Launcher$AppClassLoader@18b4aac2
        // 控制台运行:  com.shengsiyuan.jvm.classloader.MyTest16_4@16b3fc9e
        // 因为控制台定义了java.system.class.loader=com.shengsiyuan.jvm.classloader.MyTest16_4
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
