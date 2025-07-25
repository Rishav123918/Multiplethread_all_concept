package without_Runnable_method_using_lambdaexp;

public class SharedResourcesthread {
    boolean isavail=false;

    public synchronized void AddItem(){
        isavail=true;
        System.out.println("Item added by : "+ Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized void ConsumeItem(){
        System.out.println("Consumed method invoked by : "+ Thread.currentThread().getName());

        while(!isavail){
            try{
                System.out.println("Thread " + Thread.currentThread().getName() + "wait for resources");
                wait();
            }catch (Exception e) {

            }
        }
        System.out.println("Thread is consume by : "+Thread.currentThread().getName());
        isavail=false;
    }
}
