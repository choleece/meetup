package cn.choleece.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 启动线程
 *
 * @author choleece
 * @date 2018/6/25
 */
public class PCExample {
    public static void main(String[] args) throws InterruptedException {
        int proNum = 4, cusNum = 3;

        BlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<Object>(5);

        for (int i = 0; i < proNum; i++) {
            new Thread(new Producer(blockingQueue)).start();
        }

        for (int i = 0; i < cusNum ; i++) {
            new Thread(new Consumer(blockingQueue)).start();
        }

        System.out.println("主线程");
        Thread.sleep(1000);
        System.out.println("在我之后就结束了");

        System.exit(0);
    }
}
