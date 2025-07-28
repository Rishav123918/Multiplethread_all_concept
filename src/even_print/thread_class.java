package even_print;

public class thread_class {
     private final int n=10;
    public synchronized void even(int i)
    {
        try{
            if(i%2==0){
                System.out.println("even number : "+Thread.currentThread().getName()+"  "+i);

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void odd(int i)
    {
        try{
            if( i%2!=0){
                System.out.println("odd number : "+Thread.currentThread().getName()+"  "+i);
                i++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
