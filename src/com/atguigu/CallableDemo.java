package com.atguigu;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
class MyThread implements Callable{ //
    @Override
    public Integer call() throws Exception {
        System.out.println("进来了 com in call() ->Callable");
        return 200;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //多线程中获取线程的第三种方式
       /* FutureTask<Integer> future1 = new FutureTask(MyThread);
        new Thread(future1,"2").start();  //自定义一个类实现Callable 接口 ，然后运行*/
        //2
            FutureTask<String> future = new FutureTask(()->{
            System.out.println("进来了 com in call() ->Callable");
            return "1";
   });
        new Thread(future,"A").start(); //结果：进来了 com in call() ->Callable
        System.out.println("打印："+future.get());//：200
      //想要让线程运行，需要在Thread()类中添加一个Runnable 接口，但是 企业中使用Callable接口

    }
}
