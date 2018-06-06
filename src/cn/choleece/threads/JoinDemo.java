package cn.choleece.threads;

/**
 * Created by choleece on 2018/6/6.
 */
public class JoinDemo {
    // 如果一个线程实例A执行了threadB.join(),其含义是：当前线程A会等待threadB线程终止后threadA才会继续执行

    public static void main(String[] args) {
        Thread preThread = Thread.currentThread();
        for (int i = 0; i <= 10; i++) {
            Thread curThread = new JoinThread(preThread);
            curThread.start();
            preThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread thread;

        public JoinThread(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
                System.out.println(thread.getName() + " interrupt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
