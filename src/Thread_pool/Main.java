package Thread_pool;

import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, // corePoolSize
                5, // maximumPoolSize
                5, TimeUnit.SECONDS, // keepAliveTime for idle threads
                new ArrayBlockingQueue<>(10), // work queue with capacity 10
                new CustomThreadFactory(), // custom thread factory
                new CustomRejectedHandler() // custom rejection handler
        );

        // Allow even core threads to timeout
        poolExecutor.allowCoreThreadTimeOut(true);

        // Submit 25 tasks
        for (int i = 0; i < 8; i++) {
            poolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name: " + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        poolExecutor.shutdown();
    }
}

// Custom handler for rejected tasks
class CustomRejectedHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task denied: " + r.toString());
    }

}

// Custom thread factory to track thread creation
class CustomThreadFactory implements ThreadFactory {
    private int count = 0;

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setName("CustomThread-" + (++count));
        System.out.println("Created: " + th.getName());
        return th;
    }
}
/*
✅ Summary
You call submit()
It internally calls execute()
That internally calls addWorker()
 */