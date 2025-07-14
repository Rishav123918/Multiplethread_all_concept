package print_Even_odd_using_thread;

public class main {
    public static void main(String args[]){
        even_odd x=new even_odd();
        Thread even=new Thread(()->x.even(),"Even Thread");
        Thread odd=new Thread(()->x.odd(),"Odd Thread");

        even.start();
        odd.start();
    }
}
