package cn.choleece.threads;

/**
 * Volatile demo
 * @author choleece
 * @description: cn.choleece.threads
 * @date 2018/6/7 10:48
 */
public class VolatileDemo {
    private static volatile boolean isOver = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isOver){
                    System.out.println(i++);
                }
            }
        }).start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isOver = true;
    }
}
