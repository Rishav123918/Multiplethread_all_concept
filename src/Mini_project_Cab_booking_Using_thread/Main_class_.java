package Mini_project_Cab_booking_Using_thread;
import java.util.ArrayList;
import java.util.List;
public class Main_class_ {
    public static void main(String[] args) throws InterruptedException {
        DriverPool pool = new DriverPool();
        LoggerDaemon logger = new LoggerDaemon();
        logger.setDaemon(true);
        logger.start();

        // Add drivers
        Thread driver1 = new Thread(() -> pool.addDriver("Driver-A"));
        Thread driver2 = new Thread(() -> pool.addDriver("Driver-B"));
        driver1.start();
        driver2.start();

        // Create and start ride threads
        List<RideTask> rideThreads = new ArrayList<>();
        String[] riders = {"Rishav", "Alice", "Bob"};
        for (String rider : riders) {
            RideTask ride = new RideTask(rider, pool, logger);
            rideThreads.add(ride);
            ride.start();
        }

        // Wait for all rides to finish
        for (RideTask ride : rideThreads) {
            ride.join();
        }

        System.out.println("🏁 All rides completed. Main thread exiting.");
    }
}
