package Create_threadpool_using_Rnnable_callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main {
    public static void main(String args[])throws Exception{
        ExecutorService exe= Executors.newFixedThreadPool(3);

        Runnable task1=()-> System.out.println("Runnable running on thread "+Thread.currentThread().getName());

        Future<?>f1=exe.submit(task1);

        Callable<String>task2=()->{
            Thread.sleep(1000);
            return "Callable result from thread "+Thread.currentThread().getName();
        };

        Future<String>f2=exe.submit(task2);

        f1.get();
        System.out.println("Callable result "+f2.get());

        exe.shutdown();

    }
}
