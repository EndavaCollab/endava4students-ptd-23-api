package fundamentals.concurrency;

public class MainConcurrency {
    public static void main(String[] args) {
        JavaThread threadJava = new JavaThread();
        threadJava.start();

        ThreadRunnable threadRunnable = new ThreadRunnable();
        Thread threadWithRunnable = new Thread(threadRunnable);

        threadWithRunnable.start();
    }
}
