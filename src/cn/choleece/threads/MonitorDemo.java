package cn.choleece.threads;

/**
 * monitor
 * @author choleece
 * @description: cn.choleece.threads
 * @date 2018/6/7 10:24
 */
public class MonitorDemo {
    private int a = 0;

    // 对象实例锁

    public synchronized void writer() {
        a++;
    }

    public synchronized void reader() {
        int i = a;
        System.out.println(i);
    }

    public static void main(String[] args) {
        MonitorDemo monitorDemo = new MonitorDemo();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i <10000 ; i++) {
                    monitorDemo.writer();
                }
                monitorDemo.reader();
            }
        };

        // 由于是对象实例锁，所以不存在两个线程之间竞争的问题
        MonitorDemo monitorDemo1 = new MonitorDemo();
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
                    // 调用thread1 的join 方法，则需等到thread1 执行完后thread2才执行后续的操作
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10000 ; i++) {
                    monitorDemo1.writer();
                }
                monitorDemo1.reader();
            }
        };

        thread1.start();
        thread2.start();
    }
}
