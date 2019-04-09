package com.nucky.demo.singleton;

/**
 * @className TestThread
 * @Author Nucky9527
 * @Date 2019/2/20 16:27
 */
public class TestThread {
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.start();
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
        System.out.print("ping");
    }

    static void pong() {
        System.out.print("pong");
    }
}
