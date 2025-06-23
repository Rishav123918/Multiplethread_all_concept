package Reentrant_lock;


public class Main {
    public static void main(String args[]){

        sharedresources sh=new sharedresources();
        Thread t1= new Thread(()->{
           sh.produce();
        });
        sharedresources sh2=new sharedresources();
        Thread t2= new Thread(()->{
            sh.produce();
        });
        t1.start();
        t2.start();
    }
}
