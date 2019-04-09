package com.nucky.demo.lock;

/**
 * @className DeadLockTest
 * @Author Nucky9527
 * @Date 2019/2/16 13:26
 */
public class DeadLockTest {

    //原理 A 给 a资源加锁， B给 b资源加锁，之后A再去锁b资源的同时，B再去锁a资源
    //举例两人吃饭只有一双筷子
    //资源
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }

}

class Lock1 implements Runnable {

    public void run() {
        try {
            System.out.println("Lock1 running");
            while (true) {
                synchronized (DeadLockTest.obj1) {
                    System.out.println("Lock1 lock obj1 success!");
                    Thread.sleep(3000);// 获取obj1后先等一会儿，让Lock2有足够的时间锁住
                    synchronized (DeadLockTest.obj2) {
                        System.out.println("Lock1 lock obj2 success!");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Lock2 running");
            while (true) {
                synchronized (DeadLockTest.obj2) {
                    System.out.println("Lock2 lock obj2 success!");
                    Thread.sleep(3000);
                    synchronized (DeadLockTest.obj1) {
                        System.out.println("Lock2 lock obj1 success!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
