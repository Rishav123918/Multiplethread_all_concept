package Semaphore_lock;

import java.util.concurrent.Semaphore;

public class shared_resourecs {
    boolean isavail=false;
    Semaphore lock=new Semaphore(2);
    public void producer(){
        try{
            lock.acquire();
            System.out.println("Lock acquired by : " +Thread.currentThread().getName());
            isavail=true;
            Thread.sleep(1000);
        }catch (Exception e){

        }
        finally {
            lock.release();
            System.out.println("Thread released :"+ Thread.currentThread().getName());
        }
    }
}
