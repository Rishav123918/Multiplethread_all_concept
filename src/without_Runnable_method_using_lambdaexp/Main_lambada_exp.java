package without_Runnable_method_using_lambdaexp;

public class Main_lambada_exp {
    public static void main(String args[]){
        SharedResourcesthread sharedResourcesthread=new SharedResourcesthread();

        Thread producerthread=new Thread(()->{
            try{
                Thread.sleep(1000);
            }catch(Exception e){

            }
            sharedResourcesthread.AddItem();
        });

        Thread consumerthread=new Thread(()->{
           sharedResourcesthread.ConsumeItem();
        });
        producerthread.start();
        consumerthread.start();
    }
}
