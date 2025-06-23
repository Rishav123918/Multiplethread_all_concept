package Reentrent_part2_multipleobject;

import Reentrant_lock.sharedresources;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]){
        ReentrantLock l=new ReentrantLock();
        Sharedresources1 sh1=new Sharedresources1();
        Thread t1= new Thread(()->{
            sh1.produce1(l);
        });
        Sharedresources1 sh2=new Sharedresources1();
        Thread t2= new Thread(()->{
            sh2.produce1(l);
        });
        t1.start();
        t2.start();
    }
}
