package com.shengsiyuan.jvm.classloader;

/**
 * 助记符
 * anewarray: 表示创建一个引用类型的 (如类/ 接口/ 数组) 的数组, 并将其引用值压入栈顶
 * newarray: 表示创建一个指定的原始类型 (如 int/ float/ char 等) 的数组, 并将其引用值压入栈顶
 *
 * @author RichardLee
 * @version v1.0
 */
public class MyTest4 {
    public static void main(String[] args) {
        // 主动首次new才初始化
//        MyParent4 myParent4 = new MyParent4();
//        System.out.println("===");
//        MyParent4 myParent42 = new MyParent4();

        // 并不是主动使用
        // new 就一定是实例, 那么这个 new 是 new 了啥呢
        // 我个人觉得吧 这个执行了只分配了内存吧, 里面都是null, 自然没有初始化
        MyParent4[] myParent4s = new MyParent4[1];
        // 对于数组实例, 其类型是由 JVM 在运行期动态生成的, 表示为[Lcom.shengsiyuan.jvm.classloader.MyParent4
        // 这种形式, 动态生成的类型, 其父类就是 Object

        // 对于数组来说, JavaDoc 经常将构成数组的元素为 Component, 实际上就是将数组降低一个维度后的类型
        System.out.println(myParent4s.getClass());
        System.out.println(myParent4s.getClass().getSuperclass());
        System.out.println("=========");

        int[] ints = new int[1];
        System.out.println(ints.getClass());
        System.out.println(ints.getClass().getSuperclass());

    }
}
class MyParent4{
    static {
        System.out.println("MyParent4 static block");
    }
}
