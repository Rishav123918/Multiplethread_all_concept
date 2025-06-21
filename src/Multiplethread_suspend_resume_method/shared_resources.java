package Multiplethread_suspend_resume_method;

public class shared_resources {
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
