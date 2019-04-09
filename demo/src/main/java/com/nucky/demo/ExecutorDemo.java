package com.nucky.demo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @className ExecutorDemo
 * @Author Nucky9527
 * @Date 2019/2/16 0:23
 */
public class ExecutorDemo {
    public static void main(String[] args) {

        //手写线程池

        //配置相关参数
        ExecutorService executorService = new ThreadPoolExecutor(1,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            for (int i = 1; i <= 90; i++) {
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t" + new Random().nextInt(100));
                });
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            executorService.shutdown();
        }

    }
}
