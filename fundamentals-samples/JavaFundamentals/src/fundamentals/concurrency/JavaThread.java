package fundamentals.concurrency;

public class JavaThread extends Thread {
    @Override
    public void run() {
        while(true) {
            try {
                // .sleep()
                // 1000 millis => 1 second
                // 1000 * 1 * 60 => 1 minute
                // 1000 * 1 * 60 * 60 => 1 hour
                // 1000 * 1 * 60 * 60 * 24 => 1 day
                // 1000 * 1 * 60 * 60 * 24 * 7 => 1 week
                // ....
                System.out.println("Thread ");

                Thread.sleep(1000 * 3);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
