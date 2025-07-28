package Semaphore_example;

import java.util.concurrent.Semaphore;

public class sema {
    Semaphore lock1=new Semaphore(2);
    boolean x=false;
    public void getlock(int i){
        System.out.println("lock acquire by "+Thread.currentThread().getName()+ i);
        try{
            lock1.acquire();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock1.release();
            System.out.println("Lock release by : "+Thread.currentThread().getName()+i);
        }
    }
}
