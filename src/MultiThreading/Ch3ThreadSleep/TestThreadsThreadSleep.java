package MultiThreading.Ch3ThreadSleep;

public class TestThreadsThreadSleep {
    public static void main(String[] args) {
        MarketNewsThreadSleep marketNewsThreadSleep = new MarketNewsThreadSleep("Market News");
        marketNewsThreadSleep.start();

        PortfolioThreadSleep portfolioThreadSleep = new PortfolioThreadSleep("Portfolio data");
        portfolioThreadSleep.start();

        System.out.println("TestThreads is finished");
    }
}
