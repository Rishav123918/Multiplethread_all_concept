package optmistic_lock;

import java.util.concurrent.locks.StampedLock;

public class stamped {
    private double amount=10000;
    private final StampedLock lock=new StampedLock();

    public void getbalance(String user){
        long stamp=lock.tryOptimisticRead();
        double readb=amount;
        System.out.println("Before read : "+amount + " "+user);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }

        if(!lock.validate(stamp)){
            System.out.println("some account transaction is happened : "+Thread.currentThread().getName());
            stamp= lock.readLock();
            try{
                readb=amount;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }finally {
                System.out.println("Amount updated : "+readb);
                lock.unlockRead(stamp);
            }
        }else{
            System.out.println("No changes inn db"+readb);
        }
    }

    public void write(String user,double bal){
        long stamp= lock.writeLock();
        System.out.println("Performance started of write lock");
        try{

            amount=amount+bal;
            Thread.sleep(500);
            System.out.println("Amount added : "+Thread.currentThread().getName()+" "+user+ " "+bal);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("final balance : "+amount);
            lock.unlockWrite(stamp);
        }
    }
}
