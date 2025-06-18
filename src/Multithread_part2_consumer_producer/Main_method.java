package Multithread_part2_consumer_producer;

public class Main_method {
    public static void main(String[] args) {

        SharedResource sharedResource=new SharedResource();
        Thread producerthread=new Thread(new Producerthread(sharedResource));
        Thread consumerthread=new Thread(new Consumetask(sharedResource));

        producerthread.start();
        consumerthread.start();
    }
}
