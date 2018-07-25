package cn.choleece.threads.communication;

import java.util.concurrent.TimeUnit;

/**
 * @description 这里的flag放在主内中，Thread A 和主线程都能看见,所以用Volatile修饰flag保证可见性
 * Created by choleece on 2018/7/17.
 */
public class Volatile implements Runnable {

    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("Thread " + Thread.currentThread().getName() + " 正在运行...");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " 运行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile vo = new Volatile();

        new Thread(new Volatile(), "Thread A").start();

        System.out.println("主线程正在运行....");

        TimeUnit.MICROSECONDS.sleep(1000);

        vo.stopThread();

    }

    private void stopThread() {
        flag = false;
    }
}
