package Constructor_abstract;


abstract class animal{
    animal(){

        System.out.println("sdfghj");
    }
}
class dog extends animal{
   public dog(){
       super();
       System.out.println("ffff");
    }
}
public class main {
    public static void main(String args[]){
        dog obj=new dog();

    }
}
