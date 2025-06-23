package Reentrent_part2_multipleobject;

import java.util.concurrent.locks.ReentrantLock;

public class Sharedresources1 {
    boolean isavail=false;
   // ReentrantLock lock=new ReentrantLock();

    public void produce1(ReentrantLock lock) {
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
