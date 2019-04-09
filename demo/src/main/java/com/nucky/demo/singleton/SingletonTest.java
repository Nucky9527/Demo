package com.nucky.demo.singleton;

/**
 * @className SingletonTest
 * @Author Nucky9527
 * @Date 2019/2/15 23:25
 */
public class SingletonTest {


    //饿汉式
    private static SingletonTest singletonTest = new SingletonTest();

    public static SingletonTest getInstance() {

        return singletonTest;
    }


    //懒汉式  ---  优化版-线程安全的双重校验锁
    private static SingletonTest singletonTestLazy;

    public static SingletonTest getInstanceLazy() {
        //在此判断，如果对象为空，则生成实例对象
        if (null == singletonTestLazy) {
            synchronized (SingletonTest.class) {
                if (null == singletonTestLazy) {
                    singletonTestLazy = new SingletonTest();
                }
            }
        }
        return singletonTestLazy;
    }


    //静态内部类版本的单例模式
    private static class InnerObject {
        private static SingletonTest singletonTestStatic = new SingletonTest();
    }

    public static SingletonTest getInstanceStatic() {
        return InnerObject.singletonTestStatic;
    }

    //静态代码块版本的单例模式
    private static SingletonTest singletonTestStatic2;

    //静态代码块
    static {
        singletonTestStatic2 = new SingletonTest();
    }

    public static SingletonTest getInstanceStatic2() {
        return singletonTestStatic2;
    }
}
