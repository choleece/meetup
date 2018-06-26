package cn.choleece.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * 执行多任务计算
 * @author choleece
 * @date 2018/6/25
 */
public class FutureTaskForMultiCompute {
    public static void main(String[] args) {
        FutureTaskForMultiCompute inst = new FutureTaskForMultiCompute();

        // 创建任务集合
        List<FutureTask<Integer>> taskList = new ArrayList<FutureTask<Integer>>();

        // 创建线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            // 传入callable对象创建FutureTask对象
            FutureTask<Integer> ft = new FutureTask<Integer>(inst.new ComputeClass(i, "" + i));
            taskList.add(ft);
            // 提交给线程池执行任务，也可用exec的invokeAll(taskList)方法一次性提交素有任务
            exec.submit(ft);
        }

        System.out.println("所有计算任务提交完毕，主线程接着干其他的事情");

        // 开始统计各计算线程的结果
        Integer totalResult = 0;
        for (FutureTask<Integer> ft : taskList) {
            try {
                // FutureTask的get()方法会自动阻塞，直到获取计算结果为止
                totalResult += ft.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        exec.shutdown();
        System.out.println("多任务计算后的总结果是：" + totalResult);
    }

    private class ComputeClass implements Callable<Integer> {

        private Integer result = 0;

        private String taskName = "";

        public ComputeClass(Integer result, String taskName) {
            this.result = result;
            this.taskName = taskName;
            System.out.println("生成子线程任务：" + taskName);
        }

        public String getTaskName() {
            return taskName;
        }

        @Override
        public Integer call() throws Exception {
            for (int i = 0; i < 100; i++) {
                result += i;
            }
            // 休眠5秒钟，观察主线程行为，预期的结果是主线程会继续执行，到要取到FutureTask的结果时等待直至完成
            Thread.sleep(5000);
            System.out.println("子线程计算任务： " + taskName + " 计算完成");
            return result;
        }
    }
}
