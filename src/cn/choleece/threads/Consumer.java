package cn.choleece.threads;

import java.util.concurrent.BlockingQueue;

/**
 * 消费者
 *
 * @author choleece
 * @date 2018/6/25
 */
public class Consumer implements Runnable {

    protected BlockingQueue<Object> blockingQueue;

    public Consumer(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object obj = blockingQueue.take();
                System.out.println("消费者队列大小：" + blockingQueue.size());
                take(obj);
            }
        } catch (InterruptedException ex) {
            System.out.println("消费者 中断");
        }
    }

    void take(Object obj) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("消费者 读 中断");
        }
        System.out.println("消费对象：" + obj);
    }
}
