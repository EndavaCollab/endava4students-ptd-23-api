package fundamentals.concurrency;

public class ThreadRunnable implements Runnable{
    @Override
    public void run() {
        for(;;) {
            try {
                System.out.println("Thread Runnable");
                Thread.sleep(1000 * 2);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
