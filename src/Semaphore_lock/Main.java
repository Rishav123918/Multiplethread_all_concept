package Semaphore_lock;

public class Main {
    public static void main(String args[]){
        shared_resourecs sh=new shared_resourecs();
        Thread t1=new Thread(()->{
            sh.producer();
        });
        Thread t2=new Thread(()->{
            sh.producer();
        });
        Thread t3=new Thread(()->{
            sh.producer();
        });
        Thread t4=new Thread(()->{
            sh.producer();
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

/*
🔐 Semaphore Lock in Java
A Semaphore is a count-based lock provided by Java’s java.util.concurrent package.
It’s very useful when you want to limit the number of threads that can access a resource or section of code at the same time.
✅ What is a Semaphore?
A Semaphore maintains a count (permits):
When a thread acquires the semaphore, the count decreases.
When it releases the semaphore, the count increases.
If the count is 0, any new thread trying to acquire it will wait until another thread releases it.

✅ When to Use Semaphore
Limit access to a fixed number of slots/resources
Handle thread pool size manually
Manage rate limiting / throttling
Control simultaneous access to expensive system resources

🌐 2. API Rate Limiter
Problem: An external API allows only 5 concurrent requests.
How Semaphore Helps:
Use Semaphore(5) to allow only 5 requests in flight.
Remaining requests are delayed (throttled) automatically.

Semaphore apiPermit = new Semaphore(5);

void callExternalAPI() {
    apiPermit.acquire();
    // Call API
    apiPermit.release();
}
📌 Real-World Use: Payment gateways, SMS/email services, OAuth APIs, etc.
 */
