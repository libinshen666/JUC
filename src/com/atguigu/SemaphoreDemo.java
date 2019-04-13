package com.atguigu;

import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo { //Semaphore :模拟占车位 使用semaphore 的 acquire()，release()
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);// 构造器有一个参数：表示有3个车位
        for (int i = 1; i < 6; i++) {
            new Thread(new FutureTask<Integer>(()->{
                try {
                    semaphore.acquire(); //占用资源
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    try {TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();//释放资源
                }
                return 6;
            }),String.valueOf(i)).start();
        }
    }
}
