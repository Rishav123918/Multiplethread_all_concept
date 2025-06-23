package Reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class sharedresources {
    boolean isavail=false;
    ReentrantLock lock=new ReentrantLock();

    public void produce() {
        try {
            lock.lock();
            System.out.println("Thread name : " + Thread.currentThread().getName());
            isavail = true;
            Thread.sleep(500);
        }catch (Exception e){

        }
        finally {
            lock.unlock();
            System.out.println("Thread release : " + Thread.currentThread().getName());
        }
    }
}
