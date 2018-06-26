package cn.choleece.threads;

import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 *
 * @author choleece
 * @date 2018/6/25
 */
public class Producer implements Runnable {

    protected BlockingQueue<Object> blockingQueue;

    public Producer(BlockingQueue<Object> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object justProduced = getResource();
                blockingQueue.put(justProduced);
                System.out.println("生产者资源队列大小==" + blockingQueue.size());
            }
        } catch (InterruptedException e) {
            System.out.println("生产者 写 中断");
        }

    }

    Object getResource() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("生产者 读 中断");
            e.printStackTrace();
        }

        return new Object();
    }
}
