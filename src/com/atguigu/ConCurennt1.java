package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//用Lock和lock.newCondition()取代synchronized老方法( condition.await();和 condition.signalAll();取代 this.wait() 和 this.notify())
class multipResource{
    private int num=0;
    private Lock lock = new ReentrantLock();//new的类可以用抽象的接口接受
    private Condition condition = lock.newCondition();//使用
    
    public void decreament(){
        lock.lock();//上锁
        try {
            while (num == 0) {
                condition.await();//this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();//this.notifyAll()通知其他
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();//别忘了解锁
        }
    }

    public void increment(){
        lock.lock();
        try {
            while (num == 1){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
/*   private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment()throws Exception
    {
        lock.lock();
        try
        {
            //1 判断
            while(number != 0)
            {

                condition.await();//this.wait();fd
            }
            //2 干活
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3 通知
            condition.signalAll();//this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void decrement()throws Exception
    {
        lock.lock();
        try
        {
            //1 判断
            while(number == 0)
            {

                condition.await();//this.wait();fd
            }
            //2 干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3 通知
            condition.signalAll();//this.notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }*/
}

public class ConCurennt1 {
    public static void main(String[] args) {
      multipResource multipResource = new multipResource();
            new Thread(()->{
                for (int i = 0; i < 10; i++) {
                    multipResource.decreament();
                    //try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
                }
            },"mike").start();

           new Thread(()->{
            for (int i = 0; i < 10; i++) {
                    multipResource.increment();
                   // try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace();
            }
        },"soul").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                    multipResource.decreament();
                    //try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace();
            }
        },"lina").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                    multipResource.increment();
                    //try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
                }
        },"nita").start();
       /* ShareResource sr = new ShareResource();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.increment();
                    //暂停一会儿线程
                    try { Thread.sleep( 200 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.decrement();
                    try { Thread.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.increment();
                    try { Thread.sleep( 400 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 1; i <=10 ; i++)
            {
                try {
                    sr.decrement();
                    try { Thread.sleep( 500 ); } catch (InterruptedException e) { e.printStackTrace(); }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
*/
    }
}
