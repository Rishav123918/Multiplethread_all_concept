package thread_;

public class main {
    public static void main(String args[])
    {
       abc obj=()->{
           System.out.println("fly");
       };
       obj.fly();




       abc obj1=new abc(){
           @Override
           public void fly() {
               System.out.println("gfhdghg");
           }
       };
       obj1.fly();



    }
}
