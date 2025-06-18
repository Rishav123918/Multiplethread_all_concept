package Multithread_part2_consumer_producer;

public class Consumetask implements Runnable{
    SharedResource sharedResource;
    public Consumetask(SharedResource sharedResource){
        this.sharedResource=sharedResource;
    }
    @Override
    public void run() {
        System.out.println("Consumer thread : "+Thread.currentThread().getName());
        sharedResource.ConsumeItem();
    }
}
