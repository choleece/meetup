package cn.choleece.threads.communication;

/**
 * Created by choleece on 2018/7/17.
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    private boolean flag = false;

    public static class OuNum implements Runnable {

        TwoThreadWaitNotify number;

        public OuNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了。。。");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "++偶数" + number.start);
                        number.start++;
                        number.flag = false;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class JiNum implements Runnable {

        TwoThreadWaitNotify number;

        public JiNum(TwoThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("奇点线程抢到锁了。。。");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "++奇数" + number.start);
                        number.start ++;
                        number.flag = true;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        TwoThreadWaitNotify number = new TwoThreadWaitNotify();

        Thread thread1 = new Thread(new OuNum(number), "ou shu");
        Thread thread2 = new Thread(new JiNum(number), "ji shu");

        thread1.start();
        thread2.start();
    }
}
