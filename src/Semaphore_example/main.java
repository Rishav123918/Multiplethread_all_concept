package Semaphore_example;

public class main {
    public static void main(String args[]) {


        sema acc = new sema();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            Thread t = new Thread(() -> {
                acc.getlock(taskId);
            }, "Thread-" + taskId);
            t.start();
        }



    }
}
