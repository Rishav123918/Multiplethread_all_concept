package Multiplethread_Join_method;

public class Shared_space {
    boolean isavail=false;

    public synchronized void prodce(){
        System.out.println("Lock acquired");
        isavail=true;
        try{
            Thread.sleep(8000);
        }catch (Exception e){

        }
        System.out.println("Lock release");
    }
}
