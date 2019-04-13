package com.atguigu1;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * BlockingQueue<E>  //需要在构造器中 指名初识 容量
 *
 * 核心方法四组：
 * 插入     移除      检查
 * add()  remove()  element() //add 添加的数量 > 队列总容量  ：抛异常 element <==> get()
 * offer() poll() peek()  offer: //offer :添加超员就会返回false <==> add  poll <==> get()  peek 此队列的头；如果此队列为空，则返回 null
 *put() take() 不可用  //
 * offer() poll() 不可用  看构造器，比第二个多了 延迟时间
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException { //
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<String>(3);
        strings.put("李彬");
        strings.put("李彬燊");
        strings.put("李");
        strings.put("李1");

       // strings.poll();

        System.out.println( strings.take());
        System.out.println( strings.take());
        System.out.println( strings.take());


    }
}
