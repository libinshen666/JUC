package com.atguigu1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class myCache{
      private volatile Map<String,Object> map = new HashMap<>();//要知道  volatile 关键字
        //为了保证结果，要加读写锁
        private ReentrantReadWriteLock rwlock =new ReentrantReadWriteLock();

      public void put(String key,Object o){
          rwlock.writeLock().lock();//写锁
          try{
              System.out.println(Thread.currentThread().getName()+"正在写"+key);
              try {TimeUnit.MILLISECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
              map.put(key,o);
              System.out.println(Thread.currentThread().getName()+"写操作"+key);
          }catch (Exception e){
              e.printStackTrace();
          }finally {
                rwlock.writeLock().unlock(); //解锁
          }
      }

      public Object get(String key){
          rwlock.readLock().lock();// 读数据 上锁
          Object o = null;
          try {
              Object result =null;
              System.out.println(Thread.currentThread().getName()+"正在读"+key);
              try {TimeUnit.MILLISECONDS.sleep(1);}catch(InterruptedException e){e.printStackTrace();}
             o = map.get(key);
              System.out.println(Thread.currentThread().getName()+"读完成0"+key);
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              rwlock.readLock().unlock(); //aaaaaa
          }
          return o;
      }
}
public class ReentrantReadWriteLockDemo {
    public static void main(String[] args) {
        myCache myCache = new myCache();
        for (int i = 0; i < 5 ; i++) {
            final String temp = String.valueOf(i);
            new Thread(()->{
              myCache.put(temp,"李彬燊");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5 ; i++) {
            final String temp = String.valueOf(i);
            new Thread(()->{
              myCache.get(temp);
            },String.valueOf(i)).start();
        }
    }
}
