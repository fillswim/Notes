package MultiThreading.Ch2Runnable;

public class TestThreadsRunnable {
    public static void main(String[] args) {

        MarketNewsRunnable marketNewsRunnable = new MarketNewsRunnable();
        Thread mn = new Thread(marketNewsRunnable, "MarketNews");
        mn.start();

        PortfolioRunnable portfolioRunnable = new PortfolioRunnable();
        Thread pf = new Thread(portfolioRunnable, "Portfolio Data");
        pf.start();

        System.out.println("TestThreads is finished");
    }
}
