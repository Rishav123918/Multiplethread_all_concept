package Reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class sharedresources {
    boolean isavail=false;
    ReentrantLock lock=new ReentrantLock();

    public void produce() {
        try {
            lock.lock();
            System.out.println("Thread name : " + Thread.currentThread().getName());
            isavail = true;
            Thread.sleep(500);
        }catch (Exception e){

        }
        finally {
            lock.unlock();
            System.out.println("Thread release : " + Thread.currentThread().getName());
        }
    }
}

/*

✅ Scenario: ATM Withdrawal System
Imagine a system where:

Multiple users can access ATMs simultaneously

But only one user can withdraw from a particular bank account at a time

Sometimes the withdrawal method might call other methods that also need the lock

This is a perfect real-world case for ReentrantLock, where a thread might re-enter the same lock (e.g., calling checkBalance() from within withdraw()).

💡 Key Goal:
Use ReentrantLock instead of synchronized, to:

Allow more flexibility

Support reentrant locking (same thread can acquire the lock multiple times)

Handle timeouts, fairness, or interrupts if needed

🧪 Java Code Example:
package reentrantlock_example;

import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private double balance = 10000;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(String user, double amount) {
        lock.lock();  // 1st lock
        try {
            System.out.println(user + " is trying to withdraw ₹" + amount);
            checkBalance(user);  // Calls another method that also locks
            if (balance >= amount) {
                System.out.println("✅ " + user + " withdrawal successful.");
                balance -= amount;
            } else {
                System.out.println("❌ " + user + " - Insufficient funds.");
            }
        } finally {
            lock.unlock();  // 1st unlock
        }
    }

    public void checkBalance(String user) {
        lock.lock();  // 2nd lock (same thread — allowed)
        try {
            System.out.println(user + " checking balance: ₹" + balance);
        } finally {
            lock.unlock();  // 2nd unlock
        }
    }
}
🧵 Thread Usage:
public class ATMExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

         BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw("Ravi", 6000));
        Thread t2 = new Thread(() -> account.withdraw("Anita", 5000));

        t1.start();
        t2.start();
    }
}
✅ What This Demonstrates:
Feature	Example in Code
Multiple Threads	Ravi and Anita access the account simultaneously
Critical Section	withdraw() is protected with lock.lock()
Reentrant Locking	checkBalance() is called inside withdraw() — both need lock, but same thread can reacquire
Controlled Access	Only one user at a time can modify the balance

📌 Why Reentrant?
Because a thread that already holds the lock can re-enter it again — like when withdraw() internally calls checkBalance() —
without getting blocked or deadlocked.
 */
