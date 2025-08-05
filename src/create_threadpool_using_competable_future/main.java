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


    /*

💳 Real-Life Scenario: Fraud Check During Online Payment
🧩 Problem:
When a user makes a payment (say, on Amazon or Flipkart), the system needs to simultaneously check multiple fraud indicators before approving the transaction. These checks may include:
🔐 Device Trust Check
🌍 Geo-location Check
🕵️ IP Reputation Check
🧾 Transaction History Check
🧠 Machine Learning Risk Score
Each of these checks may involve a call to internal microservices or even external APIs. Doing them sequentially would make the payment flow slow, especially if each one takes around 1 second.
*/



     /*
 ✅ Real-Life Scenario: LinkedIn Notifications Panel
🎯 Goal:
When a user clicks on the 🔔 Notifications tab, LinkedIn must quickly show a personalized list, which may include:
✅ Job Alerts — New jobs matching profile
👍 Likes/Comments — Reactions on your posts
💬 Messages — Unread or new messages
👥 Mentions — When someone tags you
📢 Invitations — Connection requests
🚀 Challenge:
Each of these types of notifications comes from different services or microservices:
Jobs service
Posts service
Messaging service
Tagging service
Invitation service
If fetched one by one, it could delay the entire notifications panel.
🧠 How This Code Helps:
You're using:
ExecutorService exe = Executors.newFixedThreadPool(5);
List<CompletableFuture<String>> futures = new ArrayList<>();
This means you’re preparing 5 separate background threads — each assigned to fetch a different type of notification in parallel.

| Thread Name     | Fetches         |
| --------------- | --------------- |
| `pool-thread-1` | Job Alerts      |
| `pool-thread-2` | Likes/Comments  |
| `pool-thread-3` | Unread Messages |
| `pool-thread-4` | Mentions        |
| `pool-thread-5` | Invitations     |

 */
