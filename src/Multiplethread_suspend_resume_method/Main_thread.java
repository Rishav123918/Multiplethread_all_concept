package Multiplethread_suspend_resume_method;

public class Main_thread {
    public static void main(String args[]) throws InterruptedException{
        shared_resources s = new shared_resources();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread1 calling produce method :");
                s.prodce();
            } catch (Exception e) {

            }
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread2 calling produce method :");
                s.prodce();
            } catch (Exception e) {

            }
        });
        t1.start();
        t2.start();

        try{
            Thread.sleep(100);
            t1.suspend();
        }catch (Exception e){

        }


        System.out.println("thread 1 suspend");
        try{

            t1.resume();
//            Thread.sleep(300);
//            System.out.println("Thread 1 release ");

        }catch (Exception e){

        }

        System.out.println("Main thread finish");

    }
}
