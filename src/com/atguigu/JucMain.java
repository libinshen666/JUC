package com.atguigu;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket1 {//资源类
    private int num = 30;
    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();//一进入sale 方法就需要上锁：如果把num > 0 的判断放在lock.lock()
            try {
                if (num > 0) {
                String name = Thread.currentThread().getName();//ctrl +alt +v
                System.out.println("线程"+name+"卖出第"+(num--)+"张票,还剩"+num+"票");
                }
            } finally {
                lock.unlock();
            }
        }

}

/**
 * 1：编码风格(快速开发代码)
 * 2: 老员工和新员工开发代码的区别
 *
 *匿名内部类，不经常用
 * lamada  经长使用
 * 如何使用ladama  lmada 表达式：
 *重锁，synchronized,lock:锁你需要锁的部分
 */
public class JucMain {
    public static void main(String[] args) {
        Ticket1 ticket = new Ticket1();
          new Thread(()->{
                      //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
                      for (int i = 0; i < 30; i++) {
                          ticket.sale();
                      }
                      ticket.sale();
                  },"线程A").start();
        new Thread(()->{
            //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
            ticket.sale();
        },"线程B").start();
        new Thread(()->{
            //我们用的是new Thread(实现了Runable 接口的类，线程的名字)
            for (int i = 0; i < 30; i++) {
                ticket.sale();
            }
            ticket.sale();
        },"线程C").start();
    }
}
