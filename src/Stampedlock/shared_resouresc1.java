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
/*
This line does not block or acquire a traditional lock — it simply assumes that no other thread will write to the variable a during the read and update operation.
This is called optimistic locking.

| Method       | Lock Type           | Description                                         |
| ------------ | ------------------- | --------------------------------------------------- |
| `producer()` | ✅ Optimistic Lock   | Assumes no conflict; checks later with `validate()` |
| `consume()`  | 🔒 Pessimistic Lock | Acquires exclusive write lock to update             |


The read operation (producer()) is not stopped while a write is happening,
but its result may be invalid, so it will rollback if validate() fails.


🔁 What Happens at Runtime?
Let’s say both producer() and consume() run concurrently:
producer() calls tryOptimisticRead() — it proceeds assuming no one will write.
consume() then grabs the writeLock() and updates a.
After sleeping 10 seconds, producer() calls validate(stamp).
Since a write happened, validate() returns false.
producer() rolls back its changes.
✅ So:
Read is not blocked, but it will detect interference later and rollback
Write is exclusive, and blocks real readers (like readLock()), but not optimistic ones.
 */