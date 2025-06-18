package Multithread_part2_consumer_producer;

public class Producerthread implements Runnable{
    SharedResource res;
    public Producerthread(SharedResource res){
        this.res=res;
    }
    @Override
    public void run() {
        System.out.println("Producer thread : " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);

        }catch (Exception e){

        }
        res.AddItem();
    }
}
