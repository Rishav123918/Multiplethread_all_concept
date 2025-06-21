package Mini_project_Cab_booking_Using_thread;

public class RideTask extends Thread {
    private final String riderName;
    private final DriverPool pool;
    private final LoggerDaemon logger;

    public RideTask(String riderName, DriverPool pool, LoggerDaemon logger) {
        this.riderName = riderName;
        this.pool = pool;
        this.logger = logger;
    }

    @Override
    public void run() {
        String assignedDriver = pool.getDriver(riderName);
        System.out.println("🚕 " + riderName + " assigned to " + assignedDriver);

        try {
            System.out.println("🚗 " + riderName + "'s ride in progress...");
            Thread.sleep(4000); // simulate ride duration
            System.out.println("✅ " + riderName + "'s ride with " + assignedDriver + " completed");
            logger.incrementRideCount();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
