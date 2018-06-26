package cn.choleece.threads;

import java.util.concurrent.*;

/**
 * callable & future
 * @author choleece
 * @date 2018/6/25
 */
public class CallableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("start main thread");

        ExecutorService service = Executors.newFixedThreadPool(2);

        // 新建一个callable任务，并将其提交到ExecutorService，将返回一个描述任务情况的Future
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start new thread");
                Thread.sleep(5000);
                System.out.println("end new thread");
                return "我是返回的内容";
            }
        };

        Future<String> future = service.submit(callable);
        Thread.sleep(1000);
        String retn = future.get();
        // 关闭线程池
        service.shutdown();
        System.out.println(retn + "------end main thread");
    }
}
