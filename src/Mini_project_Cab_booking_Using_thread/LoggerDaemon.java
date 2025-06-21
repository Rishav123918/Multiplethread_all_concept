package Mini_project_Cab_booking_Using_thread;

public class LoggerDaemon extends Thread{
    private int ridesCompleted = 0;

    public synchronized void incrementRideCount() {
        ridesCompleted++;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                System.out.println("[Logger] Total completed rides so far: " + ridesCompleted);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
