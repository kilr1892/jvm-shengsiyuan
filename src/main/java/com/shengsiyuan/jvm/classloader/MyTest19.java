package com.shengsiyuan.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest19 {

    public static void main(String[] args) {
        AESKeyGenerator aesKeyGenerator = new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());

        System.out.println(MyTest19.class.getClassLoader());
    }
}
