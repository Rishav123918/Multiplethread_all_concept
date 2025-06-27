package Reentrent_part2_multipleobject;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]){
        ReentrantLock l=new ReentrantLock();
        Sharedresources1 sh1=new Sharedresources1();
        Thread t1= new Thread(()->{
            sh1.produce1(l);
        });
        Sharedresources1 sh2=new Sharedresources1();
        Thread t2= new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch (Exception e) {
            }
            sh2.produce1(l);
        });
        t1.start();
        t2.start();
    }
}
/*
✅ What is a ReentrantLock?
ReentrantLock is a class in java.util.concurrent.locks package that provides explicit locking, like synchronized, but with more flexibility and control.

It's called "reentrant" because:

A thread that already holds the lock can acquire it again without blocking itself.

🔐 Key Features:
Reentrant – same thread can lock multiple times without deadlock.

Supports tryLock(), lockInterruptibly(), and fairness policy.

Allows manual control of locking/unlocking (unlike synchronized block).

🔧 Code Example:
java
Copy
Edit
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    ReentrantLock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer method acquired lock");
            innerMethod(); // Also tries to acquire the same lock
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock(); // Reentrant: same thread can lock again
        try {
            System.out.println("Inner method acquired lock");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.outerMethod();
    }
}
🧠 Output:
pgsql
Copy
Edit
Outer method acquired lock
Inner method acquired lock
🧵 Real-World Analogy:
Think of it like entering a building with a security badge.

Once you're in (you hold the lock), you can enter inner rooms (lock again) without showing your badge again — because it's still you.

But others have to wait until you exit fully (release all locks).

📌 When to Use ReentrantLock Over synchronized:
When you need tryLock behavior (avoid blocking).

To set fair ordering (first-come-first-serve).

To have interruptible locking.
 */
