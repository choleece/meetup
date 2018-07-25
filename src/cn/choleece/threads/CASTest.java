package cn.choleece.threads;

/**
 * Created by choleece on 2018/7/17.
 */
public class CASTest {
    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();

        compareAndSwap.setValue(1);

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int exeValue = compareAndSwap.getValue();
                    boolean b = compareAndSwap.compareAndSet(exeValue, (int)(Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }
    }
}
