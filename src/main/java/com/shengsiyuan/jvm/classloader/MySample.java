package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MySample {
    public MySample() {
        System.out.println("MySample is loded by: " + this.getClass().getClassLoader());
        new MyCat();
        System.out.println("from MySample: " + MyCat.class);
    }
}
