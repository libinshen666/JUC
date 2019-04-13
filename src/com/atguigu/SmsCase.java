package com.atguigu;

import java.util.concurrent.TimeUnit;

class phone{//资源类
    public static synchronized void sendSms()throws Exception{
        //在开发中，一般使用下边的休眠方法
     try {TimeUnit.SECONDS.sleep(4);}catch(InterruptedException e){e.printStackTrace();}
        System.out.println("--sendSMS");
    }
    public synchronized void sendEmail()throws Exception{
        System.out.println("--sendEmail");
    }
    public void openPhone(){
        System.out.println("--openPhone");
    }
}
public class SmsCase {
    public static void main(String[] args) {
        phone phone = new phone();
        phone phone1 = new phone();
        new Thread(()->{
            try {
                phone.sendSms();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        //Thread.sleep():这里边的2000表示的是 2 毫秒
       // try {TimeUnit.SECONDS.sleep(2);}catch(InterruptedException e){e.printStackTrace();}
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
