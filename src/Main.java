import Multithread_part2_consumer_producer.Consumetask;
import Multithread_part2_consumer_producer.Producerthread;
import Multithread_part2_consumer_producer.SharedResource;

public class Main {
    public static void main(String[] args) {

        SharedResource sharedResource=new SharedResource();
        Thread producerthread=new Thread(new Producerthread(sharedResource));
        Thread consumerthread=new Thread(new Consumetask(sharedResource));

        producerthread.start();
        consumerthread.start();
    }
}