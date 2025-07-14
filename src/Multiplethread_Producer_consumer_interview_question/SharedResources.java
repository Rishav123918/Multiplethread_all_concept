package Multiplethread_Producer_consumer_interview_question;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResources {
    private int buffersize;
    private Queue<Integer>bufferq;

    public SharedResources(int buffersize){
        bufferq=new LinkedList<>();
        this.buffersize=buffersize;
    }
    public synchronized void produce(int item) throws Exception{
//        System.out.println("Item need to added : 1st block of producer");
        while (bufferq.size()==buffersize){
            System.out.println("Buffer queue is full,Producer is wait for consumer ");
            wait();
        }
        bufferq.add(item);
        System.out.println("Added: " + item);
        notifyAll();
    }
    public synchronized int consumer(int i)throws Exception{
        while(bufferq.isEmpty()){
            System.out.println("Buffer is empty now : ");
            wait();
        }
        int item=bufferq.poll();
        System.out.println("Item is Consumed : "+ item);
        notifyAll();
        return item;
    }

}
