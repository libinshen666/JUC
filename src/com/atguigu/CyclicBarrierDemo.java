package com.atguigu;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.FutureTask;

public class CyclicBarrierDemo {//集齐七龙珠  主要使用 CyclicBarrier 和他的await();方法
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6,()->{System.out.println("终于集齐了七龙珠");});
        //CyclicBarrier(int parties, Runnable barrierAction) //第一个参数：线程个数 第二个参数：Runnable接口
        //CountDownLatch();做减法
        //CyclicBarrier :做加法  构造方法
        //Semaphore :多个汽车强 多个停车位
        // FutureTask future = new FutureTask(new Callable());
        for (int i = 1; i <= 6 ; i++) {
            final int temp = i;
            new Thread(new FutureTask<Integer>(()->{
                System.out.println(Thread.currentThread().getName()+"集齐第"+temp+"龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                return 6;
            }),String.valueOf(i)).start();
        }
    }
}
