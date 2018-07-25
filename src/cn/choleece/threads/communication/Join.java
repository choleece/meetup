package cn.choleece.threads.communication;

/**
 * Created by choleece on 2018/7/17.
 */
public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程" + Thread.currentThread().getName());
            }
        }, "Thread A");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是线程" + Thread.currentThread().getName());
            }
        }, "Thread B");

        thread1.start();
        thread2.start();

        // 在线程A中调用ThreadB.join()，则线程A会在ThreadB执行完毕后再执行
        // 等待thread1执行完毕后执行
        thread1.join();
        // 等待thread2执行完毕后执行
        thread2.join();

        // 上述两个线程在主线程中调用join方法，所以主线程的方法会等到上述两个线程运行完毕后再执行
        System.out.println("我是主线程" + Thread.currentThread().getName());
    }
}
