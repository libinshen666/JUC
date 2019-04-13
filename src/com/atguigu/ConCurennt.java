package com.atguigu;

//使用原始的synchronized做生产者消费者问题 以及判断用while 代替 if 为什么不可以用if，
//因为 用if的话  如果num变成1，然后两个 "+"进程去访问资源，然后 进入wait状态 ，-  进程进去 ,一旦num =0，
//两个 + 进程 wait 释放，就会导致 结果出现等于  2
class Duo{//2019-2-19
    private int num = 0;
    public synchronized void increament() throws InterruptedException {//加1 操作
        while(num != 0){
            this.wait();
        }
        num++;
        System.out.println("线程"+Thread.currentThread().getName()+"完成操作"+num);
        this.notifyAll();
    }

    public synchronized void decreament() throws InterruptedException {//减1
        while(num != 1){
            this.wait();
        }
        num--;
        System.out.println("线程"+Thread.currentThread().getName()+"完成操作"+num);
        this.notifyAll();
    }
}
public class ConCurennt {
    public static void main(String[] args) {
        Duo resource = new Duo();
       new Thread(()->{
                   //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
                   for (int i = 0; i < 10; i++) {
                       try {
                           resource.increament();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               },"A").start();
         new Thread(()->{
                     //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
                     for (int i = 0; i < 10; i++) {
                         try {
                             resource.decreament();
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     }
                 },"B").start();
           new Thread(()->{
                       //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
                       for (int i = 0; i < 10; i++) {
                           try {
                               resource.decreament();
                           } catch (InterruptedException e) {
                               e.printStackTrace();
                           }
                       }
                   },"线程C").start();
             new Thread(()->{
                         //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
                         for (int i = 0; i < 10; i++) {
                             try {
                                 resource.decreament();
                             } catch (InterruptedException e) {
                                 e.printStackTrace();
                             }
                         }
                     },"线程D").start();
    }
}
