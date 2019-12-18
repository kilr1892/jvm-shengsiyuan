package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest25 implements Runnable {
    private Thread thread;

    public MyTest25() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = thread.getContextClassLoader();
        thread.setContextClassLoader(classLoader);
        // classLoader.getClass() = class sun.misc.Launcher$AppClassLoader
        // classLoader.getParent() = sun.misc.Launcher$ExtClassLoader@33b4a489
        System.out.println("classLoader.getClass() = " + classLoader.getClass());
        System.out.println("classLoader.getParent() = " + classLoader.getParent());
    }

    public static void main(String[] args) {
        new MyTest25();
    }
}
