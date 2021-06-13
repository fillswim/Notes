package MultiThreading.Ch1Thread;

public class TestThreadsThread {
    public static void main(String[] args) {
        MarketNewsThread marketNewsThread = new MarketNewsThread("Market News");
        marketNewsThread.start();

        PortfolioThread portfolioThread = new PortfolioThread("Portfolio data");
        portfolioThread.start();

        System.out.println("TestThreads is finished");
    }
}
