package cn.choleece.threads;

import java.util.concurrent.*;

/**
 * 创建线程的三种方式
 *
 * @author choleece
 * @date 2018/6/6
 */
public class CreateThreadDemo {
    public static void main(String[] args) {
        // 继承thread的方式创建线程
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("我是继承thread的方式创建线程的");
            }
        };
        thread.start();

        // 实现Runnable的方式创建线程
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是实现runnable的方式创建线程");
            }
        });
        thread1.start();

        // 实现callable接口创建线程
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "通过实现callable 接口";
            }
        });
        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
