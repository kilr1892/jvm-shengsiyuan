package com.shengsiyuan.jvm.classloader;

/**
 * .
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest18 {
    public static void main(String[] args) {
        /*
        F:\Program Files\Java\jdk8\jre\lib\resources.jar;F:\Program Files\Java\jdk8\jre\lib\rt.jar;F:\Program Files\Java\jdk8\jre\lib\sunrsasign.jar;F:\Program Files\Java\jdk8\jre\lib\jsse.jar;F:\Program Files\Java\jdk8\jre\lib\jce.jar;F:\Program Files\Java\jdk8\jre\lib\charsets.jar;F:\Program Files\Java\jdk8\jre\lib\jfr.jar;F:\Program Files\Java\jdk8\jre\classes

        F:\Program Files\Java\jdk8\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext

        F:\Program Files\Java\jdk8\jre\lib\charsets.jar;F:\Program Files\Java\jdk8\jre\lib\deploy.jar;F:\Program Files\Java\jdk8\jre\lib\ext\access-bridge-64.jar;F:\Program Files\Java\jdk8\jre\lib\ext\cldrdata.jar;F:\Program Files\Java\jdk8\jre\lib\ext\dnsns.jar;F:\Program Files\Java\jdk8\jre\lib\ext\jaccess.jar;F:\Program Files\Java\jdk8\jre\lib\ext\jfxrt.jar;F:\Program Files\Java\jdk8\jre\lib\ext\localedata.jar;F:\Program Files\Java\jdk8\jre\lib\ext\nashorn.jar;F:\Program Files\Java\jdk8\jre\lib\ext\sunec.jar;F:\Program Files\Java\jdk8\jre\lib\ext\sunjce_provider.jar;F:\Program Files\Java\jdk8\jre\lib\ext\sunmscapi.jar;F:\Program Files\Java\jdk8\jre\lib\ext\sunpkcs11.jar;F:\Program Files\Java\jdk8\jre\lib\ext\zipfs.jar;F:\Program Files\Java\jdk8\jre\lib\javaws.jar;F:\Program Files\Java\jdk8\jre\lib\jce.jar;F:\Program Files\Java\jdk8\jre\lib\jfr.jar;F:\Program Files\Java\jdk8\jre\lib\jfxswt.jar;F:\Program Files\Java\jdk8\jre\lib\jsse.jar;F:\Program Files\Java\jdk8\jre\lib\management-agent.jar;F:\Program Files\Java\jdk8\jre\lib\plugin.jar;F:\Program Files\Java\jdk8\jre\lib\resources.jar;F:\Program Files\Java\jdk8\jre\lib\rt.jar;F:\Java_Project\idea\jvm_lecture\build\classes\java\main;F:\Program Files\JetBrains\IntelliJ IDEA 2018.2.4\lib\idea_rt.jar
         */
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println();
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();
        System.out.println(System.getProperty("java.class.path"));
    }
}
