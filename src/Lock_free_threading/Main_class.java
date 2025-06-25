package Lock_free_threading;

public class Main_class {
    public static void main(String[] args) throws InterruptedException {
        LockFreeCounter counter = new LockFreeCounter();

        // Create multiple threads to increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });


        t1.start();
        t2.start();


        t1.join();
        t2.join();

        // Print final count
        System.out.println("Final count: " + counter.getCount());
    }
}

/*
🔹 Lock-Free Concurrency using Compare-and-Swap (CAS), Atomic variables, and volatile.

🧠 1. Lock-Free Concurrency — What & Why?
Lock-Free Concurrency means multiple threads can safely operate on shared data without blocking each other using traditional locks (like synchronized, ReentrantLock, etc.).

✅ Benefits:
No thread blocking or context switching.

Less overhead.

Avoids deadlocks and thread starvation.

🧮 2. Compare-And-Swap (CAS)
🔁 What Is CAS?
CAS is an atomic CPU-level instruction used to update a value only if it matches an expected value.

text
Copy
Edit
if (current_value == expected_value) {
    current_value = new_value;
    return true;
} else {
    return false;
}
🔧 Java Example:
java
Copy
Edit
AtomicInteger counter = new AtomicInteger(0);

// Atomically increment only if value is still 0
boolean updated = counter.compareAndSet(0, 1);
If another thread already changed it, CAS fails — and you can retry.

⚙️ 3. Atomic Variables
Java provides java.util.concurrent.atomic package — with classes like:

AtomicInteger

AtomicLong

AtomicReference

AtomicBoolean

These use CAS internally to perform lock-free thread-safe operations.

Example:
java
Copy
Edit
AtomicInteger count = new AtomicInteger(0);

// Thread-safe increment
count.incrementAndGet();

// CAS manually
count.compareAndSet(10, 20);
✅ These are non-blocking, super-fast for counters, flags, etc.

🌫️ 4. Volatile Variables
volatile tells the JVM:

Do not cache the variable per thread.

Always read/write directly from main memory.

Ensures visibility, but NOT atomicity.

Example:
java
Copy
Edit
volatile boolean running = true;

public void stop() {
    running = false; // visible to all threads immediately
}
🛑 Volatile ≠ Atomic
volatile alone does not protect from race conditions when multiple threads modify a value.

🔍 Summary: Differences
Feature	synchronized / Locks	volatile	Atomic classes	CAS
Thread-safe?	✅ Yes	❌ Not for write	✅ Yes	✅ Yes
Blocks threads?	❌ Yes (blocking)	❌ No	❌ No (non-blocking)	❌ No (non-blocking)
Atomic updates?	✅ Yes	❌ No	✅ Yes	✅ Yes
Memory visibility	✅ Yes	✅ Yes	✅ Yes	✅ Yes
Performance	🚫 Slower	⚠️ Only safe for reads	✅ High	✅ High

🏗️ Real-Life Analogy
🔒 synchronized → Everyone stands in line to enter a room (one at a time).

☁️ volatile → Everyone reads from the same whiteboard — always the latest version.

🧮 Atomic / CAS → Each person tries to grab and update a counter only if it hasn’t changed since last checked.
 */
