package com.nucky.demo.ObserverPattern;

/**
 * @className User
 * @Author Nucky9527
 * @Date 2019/2/16 23:33
 */

//具体的观察者
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;

    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + "收到推送消息" + message);
    }
}
