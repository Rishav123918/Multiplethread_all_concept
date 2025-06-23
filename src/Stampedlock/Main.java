package Stampedlock;

public class Main {
    public static void main(String args[]){
        shared_resouresc1 sh=new shared_resouresc1();
        Thread t1=new Thread(()->{
            sh.producer();
        });
        Thread t2=new Thread(()->{
            sh.consume();
        });
        t1.start();
        t2.start();
    }
}

/*
🔐 Lock Types: Optimistic vs Pessimistic
Let’s correct terminology and explain in detail:

✅ 1. Optimistic Locking (Optimistic Concurrency Control)
Assumes conflicts are rare

Allows multiple threads to work in parallel without locking

At the end, it checks if any conflict occurred (like a version mismatch or lock stamp invalidation)

📌 In Java:
Achieved using StampedLock.tryOptimisticRead()

Validated using lock.validate(stamp)

📌 In Databases:
Often implemented via a version column or timestamp

On update, it checks if version has changed

// Java-style
long stamp = lock.tryOptimisticRead();
int value = a;
if (!lock.validate(stamp)) {
    // Conflict detected — fall back
}
✅ 2. Pessimistic Locking (aka Traditional Locking)
Assumes conflicts are likely

Threads acquire a lock up front before accessing shared data

Blocks all other conflicting operations immediately

📌 In Java:
Achieved using:

synchronized

ReentrantLock

StampedLock.readLock() / writeLock()

📌 In Databases:
SELECT ... FOR UPDATE blocks other transactions from accessing rows

// Java-style
long stamp = lock.readLock();
try {
    int value = a;
} finally {
    lock.unlockRead(stamp);
}
🔁 Side-by-Side Comparison
Feature	Optimistic Locking	Pessimistic Locking
Conflict Assumption	Rare conflicts	Frequent conflicts
Lock Acquired Immediately	❌ No — reads proceed without lock	✅ Yes — lock before access
Performance	✅ High (if no contention)	❌ Can degrade under contention
Fallback	Needed if validation fails	Not needed — already blocked others
Java API	tryOptimisticRead() + validate()	readLock() / writeLock()
Use Case	Read-heavy systems, low write conflict	Critical sections, high contention

🧠 Real-Life Analogy
Situation	Optimistic Lock	Pessimistic Lock
Reading a book in library	Assume others won’t take it; just start	Reserve it before reading
File editing	Start editing without locking	Lock the file before editing

✅ When to Use Which?
Use Case	Lock Type
Fast reads, rare writes (e.g., cache)	Optimistic
Shared resource with many writers	Pessimistic
Database updates with version control	Optimistic
Critical financial transactions	Pessimistic
 */