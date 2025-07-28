package Thread_practice;

public class common {
    boolean avail=false;
    public void add(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }
        avail=true;
        notify();
    }

    public void consume(){
        if(!avail){
            try{
                System.out.println("not present");
                wait();
            }catch (Exception e){

            }
        }
        System.out.println(Thread.currentThread().getName()+"Consume");
    }
}
