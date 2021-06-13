package MultiThreading.Ch3ThreadSleep;

public class PortfolioThreadSleep extends Thread {

    public PortfolioThreadSleep(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                sleep(700);
                System.out.println("You have " + (500 + i) + " shapes of IBM");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + e.getMessage());
        }

    }
}
