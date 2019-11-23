package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest17_1 {
    public static void main(String[] args) throws Exception {
        // 保留classpath下的MyExample, 把MyCat删除
        /*
clazz.hashCode() = 1956725890
MySample is loded by: sun.misc.Launcher$AppClassLoader@18b4aac2

    这里用加载MySample的类加载器加载MyCat, 但是classpath下没有MyCat, 而其他的方的MyCat不能由系统类加载器加载

Exception in thread "main" java.lang.NoClassDefFoundError: com/shengsiyuan/jvm/classloader/MyCat
	at com.shengsiyuan.jvm.classloader.MySample.<init>(MySample.java:12)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
	at java.lang.Class.newInstance(Class.java:442)
	at com.shengsiyuan.jvm.classloader.MyTest17_1.main(MyTest17_1.java:15)
Caused by: java.lang.ClassNotFoundException: com.shengsiyuan.jvm.classloader.MyCat
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	... 7 more

         */

        // 删除classpath下的MyExample, 把MyCat保留
        /*
        findClass invoked: com.shengsiyuan.jvm.classloader.MySample
        class loader name: loader1
        clazz.hashCode() = 1735600054
        MySample is loded by: com.shengsiyuan.jvm.classloader.MyTest16_3@74a14482

        这里用加载MySample的类加载器(也就是我们自定义加载器)加载MyCat, 由于双亲委托机制, 会向上委托加载
        发现系统类加载器可以加载, 因此由系统类加载器加载

        MyCat is loaded by: sun.misc.Launcher$AppClassLoader@18b4aac2
         */

        // MyCat 里加入这么一句话       System.out.println("from MyCat: " + MySample.class);
        // 删除classpath下的MySample
        /*
        findClass invoked: com.shengsiyuan.jvm.classloader.MySample
        class loader name: loader1
        clazz.hashCode() = 1735600054
        MySample is loded by: com.shengsiyuan.jvm.classloader.MyTest16_3@74a14482
        MyCat is loaded by: sun.misc.Launcher$AppClassLoader@18b4aac2

        父加载器是无法访问子加载器的名称空间, 自然是找不到了
        父加载器加载的类是无法找到(无法访问)子加载器加载的类
        子类加载器加载的类是可以访问(可以找到)父加载器加载的类
        (这里有点像继承的父子设计, 父类无法使用子类的方法, 但子类可以使用父类的方法)

        Exception in thread "main" java.lang.NoClassDefFoundError: com/shengsiyuan/jvm/classloader/MySample
            at com.shengsiyuan.jvm.classloader.MyCat.<init>(MyCat.java:13)
            at com.shengsiyuan.jvm.classloader.MySample.<init>(MySample.java:12)
            at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
            at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
            at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
            at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
            at java.lang.Class.newInstance(Class.java:442)
            at com.shengsiyuan.jvm.classloader.MyTest17_1.main(MyTest17_1.java:51)
        Caused by: java.lang.ClassNotFoundException: com.shengsiyuan.jvm.classloader.MySample
            at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
            at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
            at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
            at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
            ... 8 more

        Process finished with exit code 1
         */
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        loader1.setPath("E:\\Program_Data\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MySample");
        System.out.println("clazz.hashCode() = " + clazz.hashCode());
        Object object = clazz.newInstance();
    }
}
