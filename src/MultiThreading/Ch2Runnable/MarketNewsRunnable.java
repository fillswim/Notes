package MultiThreading.Ch2Runnable;

public class MarketNewsRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("The stock market is improving!");
    }
}
