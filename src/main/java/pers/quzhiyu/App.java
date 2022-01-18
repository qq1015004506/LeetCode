package pers.quzhiyu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Hello world!
 *
 */
public class App 
{
    static AtomicInteger ai = new AtomicInteger(0);
    class test{
        public void haha(){
            ai.addAndGet(1);
        }
    }
    public static void main( String[] args )
    {
        CountDownLatch cdl = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            int start = i * 200;
            Thread thread = new Thread(()->{
                for (int j = start; j < start + 200; j++) {
                    System.out.println(Thread.currentThread().getName() + ":" +j);
                }
                cdl.countDown();
            },"thread-" + i);
            thread.start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(ai.get());
    }
}
