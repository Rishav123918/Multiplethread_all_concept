package Deamon_thread_reallifeexample;

public class Autosaved_concept {
    public static void main(String[] args) {
        // Daemon thread for auto-saving
        Thread autoSave = new Thread(() -> {
            while (true) {
                System.out.println("✅ Auto-saving draft...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        autoSave.setDaemon(true); // Background
        autoSave.start();

        // Simulate user session in a user thread
        Thread userSession = new Thread(() -> {
            System.out.println("📝 User started editing the document...");
            try {
                // Simulate unknown long session — 30 seconds here
                for (int i = 1; i <= 6; i++) {
                    System.out.println("⌨️  User is typing... " + i);
                    Thread.sleep(5000);
                }
                System.out.println("👋 User closed the editor.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        userSession.start();

        try {
            userSession.join(); // Main waits for user thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("🏁 App exits after user finishes.");
    }
}

/*
✅ Code Overview
You have:

A daemon thread called autoSave that prints every 5 seconds.

A user thread called userSession that simulates a user typing.

The main() method waits for userSession using .join() before exiting.
 */

/*
Excellent question. You're asking:

"Why does ✅ Auto-saving draft... print multiple times instead of just once?"

Let’s break it down simply.

✅ Reason: It's inside a while (true) infinite loop
Here's the code:
java
Copy
Edit
Thread autoSave = new Thread(() -> {
    while (true) {
        System.out.println("✅ Auto-saving draft...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            break;
        }
    }
});
🔁 What this does:
Enters an infinite loop: while (true)

Prints: ✅ Auto-saving draft...

Waits (sleeps) for 5 seconds

Repeats steps 1–3 again and again

Stops only if interrupted or JVM exits

🔁 Timeline of What Happens:
Time (sec)	Output
0s	✅ Auto-saving draft...
5s	✅ Auto-saving draft...
10s	✅ Auto-saving draft...
15s	✅ Auto-saving draft...
...	Keeps going while app is running

🧠 Why "multiple times" makes sense:
In a real-world app like Google Docs, the auto-save doesn't run just once — it keeps checking every few seconds to save updates repeatedly, just like this.

🚫 What if you wanted it only once?
If you want ✅ Auto-saving draft... to print only once, remove the while (true) loop:

java
Copy
Edit
Thread autoSave = new Thread(() -> {
    System.out.println("✅ Auto-saving draft...");
});
But that wouldn't be a "real" auto-save — that’s just a one-time log.

✅ Summary:
Behavior	Why it happens
Multiple prints	Because of while (true) loop
Every 5 seconds	Because of Thread.sleep(5000)
Ends when JVM exits	Because it's a daemon thread
 */