package MultiThreading.Ch2Runnable;

public class PortfolioRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("You have 500 shares of IBM");
    }
}
