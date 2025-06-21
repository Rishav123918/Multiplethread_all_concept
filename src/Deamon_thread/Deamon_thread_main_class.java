package Deamon_thread;

public class Deamon_thread_main_class {
    public static void main(String args[]){
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        daemonThread.setDaemon(true); // mark as daemon
        daemonThread.start();

        System.out.println("Main thread sleeping for 3 seconds...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        System.out.println("Main thread finished");
    }
}
