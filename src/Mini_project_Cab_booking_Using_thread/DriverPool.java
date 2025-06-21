package Mini_project_Cab_booking_Using_thread;

import java.util.LinkedList;
import java.util.Queue;

public class DriverPool {
    private final Queue<String> availableDrivers = new LinkedList<String>();
    public synchronized void addDriver(String driverName) {
        availableDrivers.offer(driverName);
        System.out.println("Driver " + driverName + " is now available");
        notify();
    }
    public synchronized String getDriver(String riderName){
        while (availableDrivers.isEmpty()) {
            try {
                System.out.println("Dispatcher waiting for drivers for rider " + riderName);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return availableDrivers.poll();
    }
}