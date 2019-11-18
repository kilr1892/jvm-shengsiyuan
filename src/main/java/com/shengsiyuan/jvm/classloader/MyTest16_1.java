package com.shengsiyuan.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest16_1 extends ClassLoader {
    /** 自定义类加载器的名字 */
    private String classLoaderName;
    /** 指定根路径 */
    private String path;
    /** .class后缀名 */
    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16_1(String classLoaderName) {
        super();// 将系 统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_1(ClassLoader parent, String classLoaderName) {
        super(parent);// 显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        // 压根没有被执行过
        System.out.println("findClass invoked: " + className);
        System.out.println("class loader name: " + this.classLoaderName);
        byte[] data = this.loadClassData(className);

        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".", "\\");

        try {
            // 加载的文件名
            is = new FileInputStream(new File(this.path + className + this.fileExtension));

            baos = new ByteArrayOutputStream();

            // 常规读写, 没用上缓存的那种
            int ch = 0;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }

            data = baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    public static void main(String[] args) throws Exception {
        /*
          删除项目路径下的MyTest1.class文件
          复制一份MyTest1.class文件到E:\Program_Data\com\shengsiyuan\jvm\classloader
          现在目标文件不在项目的路径(classpath)下时, 终于调用自定义的类加载器
        */
        //findClass invoked: com.shengsiyuan.jvm.classloader.MyTest1
        //class loader name: loader1
        //clazz = 356573597
        //object = com.shengsiyuan.jvm.classloader.MyTest1@677327b6
        MyTest16_1 loader1 = new MyTest16_1("loader1");
        loader1.setPath("E:\\Program_Data\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz.hashCode() );
        Object object = clazz.newInstance();
        System.out.println("object = " + object.hashCode());
        System.out.println();
        /*
        重新在classpath下生成MyTest1.class文件, 其余条件不变
         */
        //clazz = 1163157884
        //object = 1956725890
        //clazz = 1163157884
        //object = 356573597
        /*
        说明系统类加载器尝试加载, 发现能加载, 就加载了
        第二次系统类加载器发现自己加载过了, 就直接用了
         */

        /*
        这次再将classpath下生成MyTest1.class文件删除, 看看结果如何
         */
        //findClass invoked: com.shengsiyuan.jvm.classloader.MyTest1
        //class loader name: loader1
        //clazz = 356573597
        //object = 1735600054
        //findClass invoked: com.shengsiyuan.jvm.classloader.MyTest1
        //class loader name: loader2
        //clazz = 1836019240
        //object = 325040804
        /*
        这次自己的类加载器都被执行了, 且两次hashcode不一样
        由于命名空间的问题, 因此可以多次加载同一个类
         */
        MyTest16_1 loader2 = new MyTest16_1("loader2");
        loader2.setPath("E:\\Program_Data\\");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz2.hashCode() );
        Object object2 = clazz.newInstance();
        System.out.println("object = " + object2.hashCode());
        System.out.println();
    }
}