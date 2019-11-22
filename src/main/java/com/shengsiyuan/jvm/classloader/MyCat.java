package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyCat {
    public MyCat() {
        System.out.println("MyCat is loaded by: " + this.getClass().getClassLoader());

    }
}
