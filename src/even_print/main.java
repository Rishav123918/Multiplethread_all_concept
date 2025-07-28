package even_print;

public class main {
    public static void main(String args[]){
        thread_class t=new thread_class();

        for(int i=1;i<=10;i++)
        {
            final int id=i;
            Thread t1=new Thread(()->{
                t.even(id);
            },"Even");
            Thread t2=new Thread(()->{
                t.odd(id);
            },"Odd");

            t2.start();
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            t1.start();
        }

    }
}
