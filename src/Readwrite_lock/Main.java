package Readwrite_lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String args[]){
        Shared_resources_1 sh=new Shared_resources_1();
        ReadWriteLock lock=new ReentrantReadWriteLock();
        Thread t1=new Thread(()->{
           sh.prooucer(lock);
        });
        Thread t2=new Thread(()->{
            sh.prooucer(lock);
        });
        Shared_resources_1 sh2=new Shared_resources_1();
        Thread t3=new Thread(()->{
            try{
                Thread.sleep(2000);
                sh2.consumer(lock);
            }catch (Exception e){

            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

/*
🔄 Java Example with ReentrantReadWriteLock
Java implements shared and exclusive locking using the ReentrantReadWriteLock.

✅ Shared Lock (readLock()):
Allows multiple threads to read concurrently, but blocks when a writer is active.

✅ Exclusive Lock (writeLock()):
Only one writer can acquire it, and no readers or other writers can proceed.


✅ Real-World Use Case:
Cache access (read-heavy system)
Configuration access (read many times, updated occasionally)

It has two separate locks:
readLock() → for read operations
writeLock() → for write operations
 */

/*
💡 Real-Life Analogy:
Shared Lock = Public library: many people can read the same book at once.
Exclusive Lock = Editor: only one person can make changes, and others must wait.
 */
