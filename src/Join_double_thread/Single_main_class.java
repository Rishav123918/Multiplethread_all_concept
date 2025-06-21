package Join_double_thread;

public class Single_main_class {
    public static void main(String args[])throws InterruptedException{
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 1 running: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 1 finished");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 2 running: " + i);
                try {
                    Thread.sleep(100); // simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread 2 finished");
        });

        // Start Thread 1
        t1.start();
        t1.join();
        t2.start();
        t2.join();
//        try {
//            // Wait for Thread 1 to finish before starting Thread 2
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Now start Thread 2
//        t2.start();
//
//        try {
//            // Wait for Thread 2 to finish before ending main
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("✅ Main thread finished after both threads");
    }
}
