package com.nucky.demo.ObserverPattern;

/**
 * @className ObserverTest
 * @Author Nucky9527
 * @Date 2019/2/16 23:50
 */
public class ObserverTest {
    public static void main(String[] args) {
        //创建公众号实例对象--被观察者
        WechatServer server = new WechatServer();
        //创建观察者
        User userZhang = new User("zhangsan");
        User userLi = new User("Lisi");
        User userWang = new User("WangWu");

        //订阅公众号---将观察者的引用放入集合当中
        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        //公众号发布消息
        server.setInformation("Hello World!!");
        System.out.println("-----------------------------------");
        //取消订阅
        server.removeObserver(userZhang);
        //公众号更新消息
        server.setInformation("Hello Java!!!");

    }
}
