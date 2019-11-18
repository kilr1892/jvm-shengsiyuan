package com.shengsiyuan.jvm.classloader;

import java.io.*;

/**
 * 网络类加载器.
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest16 extends ClassLoader {
    /** 自定义类加载器的名字 */
    private String classLoaderName;
    /** .class后缀名 */
    private final String fileExtension = ".class";

    public MyTest16(String classLoaderName) {
        super();// 将系 统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
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

    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;

        try {
            // 加载的文件名
            is = new FileInputStream(new File(name + this.fileExtension));
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

    public static void test(ClassLoader classLoader) throws Exception {
        Class<?> clazz = classLoader.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        Object object = clazz.newInstance();

        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());
    }

    public static void main(String[] args) throws Exception {
        //com.shengsiyuan.jvm.classloader.MyTest1@4554617c
        //sun.misc.Launcher$AppClassLoader@18b4aac2
        MyTest16 loader1 = new MyTest16("loader1");
        test(loader1);
    }
}
