package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest21 {
    public static void main(String[] args) throws Exception {
        /*
        findClass invoked: com.shengsiyuan.jvm.classloader.MyPerson
class loader name: loader1
findClass invoked: com.shengsiyuan.jvm.classloader.MyPerson
class loader name: loader2
false
Exception in thread "main" java.lang.reflect.InvocationTargetException
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.shengsiyuan.jvm.classloader.MyTest21.main(MyTest21.java:32)
Caused by: java.lang.ClassCastException: com.shengsiyuan.jvm.classloader.MyPerson cannot be cast to com.shengsiyuan.jvm.classloader.MyPerson
	at com.shengsiyuan.jvm.classloader.MyPerson.setMyPerson(MyPerson.java:13)
	... 5 more

         */
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        MyTest16_3 loader2 = new MyTest16_3("loader2");

        loader1.setPath("E:\\Program_Data\\");
        loader2.setPath("E:\\Program_Data\\");

        Class<?> clazz1 = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyPerson");
        // false
        // 当用自定义加载类加载的时候
        System.out.println(clazz1 == clazz2);

        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();

        Method method = clazz1.getMethod("setMyPerson", Object.class);
        // 抛出强转异常
        // 因为两个命名空间里的类, 是无法看到彼此的类, 自然就无法强转了
        // 这给invoke的意思是, 第一个参数是谁调用, 第二个参数是传入的参数
        method.invoke(object1, object2);
    }
}
