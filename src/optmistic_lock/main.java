package optmistic_lock;

public class main {
    public static void main(String args[]){
        stamped s=new stamped();
        Thread t1=new Thread(()->{
            s.getbalance("alice");
        });
        Thread t2=new Thread(()->{
            s.write("bob",2000);
        });

        t1.start();
        try{
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t2.start();
    }
}
