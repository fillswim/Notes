package MultiThreading.Ch3ThreadSleep;

public class MarketNewsThreadSleep extends Thread {

    public MarketNewsThreadSleep(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                sleep(1000);
                System.out.println("The market is improving " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + e.getMessage());
        }

        System.out.println("The stock market is improving!");
    }
}
