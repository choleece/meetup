package cn.choleece.threads;

/**
 * 关于线程中断
 * @author choleece
 * @date 2018/6/6
 */
public class InterruptDemo {
    public static void main(String[] args) {

        // sleepThread线程睡眠1000ms
        final Thread sleepThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        };

        // 死循环
        Thread deadThread = new Thread() {
            @Override
            public void run() {
                while (true) {}
            }
        };

        sleepThread.start();
        deadThread.start();
        sleepThread.interrupt();
        deadThread.interrupt();
        while (sleepThread.isInterrupted()) {};
        System.out.println("sleepThread isInterrupted: " + sleepThread.isInterrupted());
        System.out.println("busyThread isInterrupted: " + deadThread.isInterrupted());
    }
}
