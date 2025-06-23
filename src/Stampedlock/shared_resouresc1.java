package Stampedlock;

import java.util.concurrent.locks.StampedLock;

public class shared_resouresc1 {
    int a=10;
    StampedLock lock=new StampedLock();
    public void producer(){
        long stamp=lock.tryOptimisticRead();
        try{
            System.out.println("Taken opstimatic lock");
            a=11;
            Thread.sleep(10000);
            if(lock.validate(stamp)){
                System.out.println("Updated successfully :"+ a );
            }else{
                System.out.println("Previous value : " + a);
                a=10;
                System.out.println("Roll back :"+ a );
            }
        }catch (Exception e){

        }

    }

    public void consume(){
        long stamp=lock.writeLock();
        System.out.println("Write lock ackquired by :" +Thread.currentThread().getName());

        try{
            System.out.println("performaing work");
            a=11;
        }catch(Exception e){

        }finally {
            lock.unlockWrite(stamp);
            System.out.println("Write lock released by :" + Thread.currentThread().getName());
        }
    }
}
