package print_Even_odd_using_thread;

public class even_odd {
    private int st=1;
    private final int maxi=10;

    public synchronized void even(){
        while(st<=maxi){
            if(st%2!=0){
                try{
                    wait();
                }catch (Exception e){
                   Thread.currentThread().interrupt();
                }
            }else{
                System.out.println("Thread name "+Thread.currentThread().getName()+ " " +st);
                st++;
                notifyAll();
            }
        }
    }
    public synchronized void odd(){
        while(st<=maxi){
            if(st%2==0){
                try{
                    wait();
                }catch (Exception e){
                    Thread.currentThread().interrupt();
                }
            }else{
                System.out.println("Thread name "+Thread.currentThread().getName()+ " " +st);
                st++;
                notifyAll();
            }
        }
    }


}
