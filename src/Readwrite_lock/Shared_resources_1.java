package Readwrite_lock;

import java.util.concurrent.locks.ReadWriteLock;

public class Shared_resources_1 {
    boolean isavail=false;
    public void prooucer(ReadWriteLock lock){
        try{
            lock.readLock().lock();
            System.out.println("Read lock acquired by : "+ Thread.currentThread().getName());
           // isavail=true;
            Thread.sleep(500);
        }catch (Exception e){

        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read lock Release by : "+ Thread.currentThread().getName());
        }
    }

    public void consumer(ReadWriteLock lock){
        try{
            lock.writeLock().lock();
            System.out.println("Write lock acquired by : "+ Thread.currentThread().getName());
            isavail=false;

        }catch (Exception e){

        }
        finally {
            lock.writeLock().unlock();
            System.out.println("Write lock Release by : "+ Thread.currentThread().getName());
        }
    }
}
