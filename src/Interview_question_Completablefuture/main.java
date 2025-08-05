package Interview_question_Completablefuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    public static void stimulatedelay()
    {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[])
    {
        ExecutorService exe= Executors.newFixedThreadPool(5);

        List<CompletableFuture<String>>futures=new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            final int id=i;
            CompletableFuture<String>f=CompletableFuture.supplyAsync(()->{
                try{
                    stimulatedelay();
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }
                return "Task i completed by thread:"+Thread.currentThread().getName();
            },exe);
           futures.add(f);
        }
        CompletableFuture<Void>all=CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[0])
        );
        all.join();
        futures.forEach(x-> System.out.println(x.join()));
        exe.shutdown();
    }
}

/*
You are tasked with executing multiple time-consuming tasks (e.g., data fetching from external sources) in parallel using Java.
Write a program using CompletableFuture.supplyAsync() to:
Simulate the execution of 5 parallel tasks.
Each task should:
Sleep for 1 second.
Return a string in the format:
"Task i completed by thread: [thread name]"
Collect the results and print them all once all tasks are finished.
❓ Follow-up Questions:
What will happen if you don't use a custom Executor with supplyAsync()?
How would you modify the program to use a fixed thread pool of size 2?
How do you ensure that results are printed in submission order, not completion order?
What changes would you make to handle exceptions thrown by any task?
 */
