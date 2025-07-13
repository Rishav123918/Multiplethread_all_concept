package Create_miniproject_cometablefuture_properties;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
    private static void stimulatedelay(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public static void main(String args[])throws Exception{
        ExecutorService exe= Executors.newFixedThreadPool(5);

        CompletableFuture<Double>baseprice=CompletableFuture.supplyAsync(()->{
            System.out.println("Fetching base price");
            stimulatedelay();
            return 100.0;
        },exe);

        CompletableFuture<Double>discountprice=CompletableFuture.supplyAsync(()->{
            System.out.println("Discounted prices apply");
            stimulatedelay();
            return 10.0;
        },exe);

        CompletableFuture<Double>discountedprices=baseprice.thenCombine(discountprice,(price,discount)->{
            double discounted = price - (price * discount / 100);
            System.out.println("Discounted Price: " + discounted);
            return discounted;
        });

        CompletableFuture<Double>tax=discountedprices.thenApply(price->{
            double tax1 = price * 0.18;
            return price + tax1;
        });

        tax.thenAcceptAsync(Finalprice->{
            System.out.println("Final price is :"+Finalprice);
        },exe);

        tax.join();
        exe.shutdown();

    }
}
