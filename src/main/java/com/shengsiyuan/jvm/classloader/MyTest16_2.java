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
public class MyTest16_2 extends ClassLoader {
    /** 自定义类加载器的名字 */
    private String classLoaderName;
    /** 指定根路径 */
    private String path;
    /** .class后缀名 */
    private final String fileExtension = ".class";

    public void setPath(String path) {
        this.path = path;
    }

    public MyTest16_2(String classLoaderName) {
        super();// 将系 统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16_2(ClassLoader parent, String classLoaderName) {
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
        MyTest16_2 loader1 = new MyTest16_2("loader1");
        loader1.setPath("E:\\Program_Data\\");
        Class<?> clazz = loader1.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz.hashCode() );
        Object object = clazz.newInstance();
        System.out.println("object = " + object.hashCode());
        System.out.println();

        // 这里把loader1作为2的父加载器
        // 双亲委托机制可知, 会由loader1 加载
        // loader1和loader2是同一类的实例, 但可以设定父子关系, 是因为类加载器之间是包含关系, 不是树形结构
        MyTest16_2 loader2 = new MyTest16_2(loader1,"loader2");
        loader2.setPath("E:\\Program_Data\\");
        Class<?> clazz2 = loader2.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz2.hashCode() );
        Object object2 = clazz.newInstance();
        System.out.println("object = " + object2.hashCode());
        System.out.println();

        //findClass invoked: com.shengsiyuan.jvm.classloader.MyTest1
        //class loader name: loader1
        //clazz = 356573597
        //object = 1735600054
        //
        //clazz = 356573597
        //object = 21685669
        //
        //findClass invoked: com.shengsiyuan.jvm.classloader.MyTest1
        //class loader name: loader3
        //clazz = 325040804
        //object = 1173230247
        /*
        有父类用父类, 没父类自己加载
         */
        MyTest16_2 loader3 = new MyTest16_2(loader2,"loader3");
        loader3.setPath("E:\\Program_Data\\");
        Class<?> clazz3 = loader3.loadClass("com.shengsiyuan.jvm.classloader.MyTest1");
        System.out.println("clazz = " + clazz3.hashCode() );
        Object object3 = clazz.newInstance();
        System.out.println("object = " + object3.hashCode());
        System.out.println();
    }
}