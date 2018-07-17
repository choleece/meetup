package cn.choleece.threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronize 关键字demo
 * @author choleece
 * @description: cn.choleece.threads
 * @date 2018/6/7 9:36
 */
public class SynchronizedDemo implements Runnable {
    private static int count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedDemo());
            thread.setName("thread-" + i);
            thread.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("result: " + count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000 ; i++) {
            count++;
        }
        System.out.println(Thread.currentThread().getName());
    }
}
