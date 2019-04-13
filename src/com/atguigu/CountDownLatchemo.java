package com.atguigu;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;

public class CountDownLatchemo { //CountDownLatch  结合 枚举 一块使用（做减法）
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);//构造器里边需要有1个integer类型的数
        for (int i = 1; i <= 6; i++) {//Thread(x,y):x:runnable y:String  （String：枚举中的对象的属性有String的）
            new Thread(new FutureTask<Integer>(()->{
                System.out.println(Thread.currentThread().getName()+"国被灭");
                countDownLatch.countDown();
                return 6;
            }),CountryEnum.foreach_CountryEnum(i).getGetMessage()).start();
        }
        countDownLatch.await();
        System.out.println("大秦一统华夏");

        //枚举的使用
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getGetMessage());
        System.out.println(CountryEnum.ONE.getGetcode());
        /*for (int i = 0; i <6 ; i++) {
            new Thread(()->{
                System.out.println("当前线程"+Thread.currentThread().getName());
                countDownLatch.countDown();//执行完一个县城就-1
        },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("当前线程名字"+Thread.currentThread().getName());*/

        //作业：
        for (int i = 1; i <= 6; i++) {//Thread(x,y):x:runnable y:String  （String：枚举中的对象的属性有String的）
            new Thread(new FutureTask<Integer>(()->{
                System.out.println("今天是周"+Thread.currentThread().getName());
                countDownLatch.countDown();
                return 6;
            }),WeekEnmu.for_item(i).getGetMessage()).start();//第二个参数是线程类的名字
        }
        countDownLatch.await();
        System.out.println("56656");
    }
}
