package Multiplethread_Join_method;

import Multiplethread_suspend_resume_method.shared_resources;

public class Main_clss {
    public static void main(String args[]) {
        shared_resources s = new shared_resources();
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread1 calling produce method :");
                s.prodce();
            } catch (Exception e) {

            }
        });

        t1.start();
        try{
            t1.join();
        }catch (Exception e){

        }
        System.out.println("Main thread finish");

    }
}
