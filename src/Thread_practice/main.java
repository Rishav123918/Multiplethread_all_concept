package Thread_practice;

public class main {
    public static void main(String args[]){
        common c=new common();
        Thread t1=new Thread(()->{
            try{
                c.add();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2=new Thread(()->{
            try{
                c.consume();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
