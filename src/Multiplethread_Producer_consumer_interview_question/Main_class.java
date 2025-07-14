package Multiplethread_Producer_consumer_interview_question;

public class Main_class {
    public static void main(String args[]){
        SharedResources sharedResources=new SharedResources(5);
        Thread producerthread=new Thread(()->{
            try{
                for(int i=1;i<8;i++){
                    sharedResources.produce(i);
                }
            }catch (Exception e){
            }
        });

        Thread consumerthread=new Thread(()->{
            try{
                for(int i=1;i<8;i++){
                    sharedResources.consumer(i);
                }
            }catch (Exception e){
            }
        });
        producerthread.start();
        consumerthread.start();
    }
}
