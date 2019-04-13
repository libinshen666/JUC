package com.atguigu1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDmo1 {  //考察 Callable的第二个知识点  :阻塞
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft= new FutureTask<Integer>(()->{
             try {
                 TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e){e.printStackTrace();}
            //System.out.println("skfjdjfd");
            return 1;
        });
        new Thread(ft,"a").start();
        //System.out.println(ft.get());  //注意如果前边的线程不执行完 就不能执行 该方法 。所以就会导致阻塞


        //使用轮训 的方式
        while(!ft.isDone()){ //轮训用while   会一直访问CPU资源，浪费资源。
            System.out.println(ft.isDone()); //false
            System.out.println("wait---");
        }
        System.out.println(Thread.currentThread().getName()+"take man");
    }
}
