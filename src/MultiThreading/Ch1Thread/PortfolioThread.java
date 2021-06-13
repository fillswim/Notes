package MultiThreading.Ch1Thread;

public class PortfolioThread extends Thread {

    public PortfolioThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("You have 500 shares of IBM");
    }
}
