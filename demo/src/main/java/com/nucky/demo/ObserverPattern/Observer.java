package com.nucky.demo.ObserverPattern;


//定义一个观察者接口，具体的观察者都需要实现接口
public interface Observer {

    //及时更新消息
    public void update(String message);
}
