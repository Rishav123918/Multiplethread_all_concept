import java.io.FileNotFoundException;

public class exception {
    public static void main(String args[])throws FileNotFoundException{
//        try{
//            method1("fgh");
//        } catch (FileNotFoundException e) {
//
//        }

        method1("ghfh");

    }

    public static void method1(String string) throws FileNotFoundException {
        if (string.equals("abc")) {
        throw new FileNotFoundException("fgdg");
    }
    }
}

