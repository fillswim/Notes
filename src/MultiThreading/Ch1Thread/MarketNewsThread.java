package MultiThreading.Ch1Thread;

public class MarketNewsThread extends Thread {

    public MarketNewsThread(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        System.out.println("The stock market is improving!");
    }
}
