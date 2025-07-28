package Multithread_part2_consumer_producer;

public class Main_method {
    public static void main(String[] args) {

        SharedResource sharedResource=new SharedResource();
        Thread producerthread=new Thread(()->{
            sharedResource.AddItem();
            try{
               Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getStackTrace());
            }
        },"Producer");
        Thread consumerthread=new Thread(()->{
            sharedResource.ConsumeItem();
            try{
                Thread.sleep(1000);

            }catch(Exception e){
                System.out.println(e.getStackTrace());
            }
        },"Consumer");




        producerthread.start();
        consumerthread.start();
    }
}
