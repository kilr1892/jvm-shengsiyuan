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
public class MyTest16_3 extends ClassLoader {
    /** 自定义类加载器的名字 */
    private String classLoaderName;
    /** 指定根路径 */
    private String path;
    /** .class后缀名 */
    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16_3(String classLoaderName) {
        super();// 将系 统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_3(ClassLoader parent, String classLoaderName) {
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
        MyTest16_3 loader1 = new MyTest16_3("loader1");
        loader1.setPath("E:\\Program_Data\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz.hashCode() );
        Object object = clazz.newInstance();
        System.out.println("object = " + object.hashCode());
        System.out.println();

        /*
        当指向新的对象后, 再次执行gc, 就可以看到了(-X:+TraceClassUnloading)
         */
        loader1 = null;
        clazz = null;
        object = null;

        System.gc();

        Thread.sleep(100000);

        loader1 = new MyTest16_3("loader1");
        loader1.setPath("E:\\Program_Data\\");
        clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");


        System.out.println("clazz = " + clazz.hashCode() );
        object = clazz.newInstance();
        System.out.println("object = " + object.hashCode());
        System.out.println();


    }
}