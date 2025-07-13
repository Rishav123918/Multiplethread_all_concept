package create_threadpool_using_competable_future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void main(String args[])throws Exception{
        ExecutorService exe= Executors.newFixedThreadPool(5);

        List<CompletableFuture<String>>futures=new ArrayList<>();

        for(int i=1;i<=5;i++){
            final int taskid=i;

            CompletableFuture<String>f=CompletableFuture.supplyAsync(()->{
              try {
                  Thread.sleep(1000);
              }catch(InterruptedException e) {
                  Thread.currentThread().interrupt();
              }
              return "Task id : "+taskid+" Completed on : "+ Thread.currentThread().getName();
            },exe);
              futures.add(f);
            }

        CompletableFuture<Void> allDone = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );

        allDone.join();
        futures.forEach(x-> System.out.println(x.join()));

        exe.shutdown();
        }
    }

