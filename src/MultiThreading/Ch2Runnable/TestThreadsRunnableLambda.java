package MultiThreading.Ch2Runnable;

public class TestThreadsRunnableLambda {
    public static void main(String[] args) {

        Thread mn = new Thread(() -> System.out.println("The stock market is improving!"),
                "MarketNews");
        mn.start();

        Thread pf = new Thread(() ->System.out.println("You have 500 shares of IBM"),
                "Portfolio Data");
        pf.start();

        System.out.println("TestThreads is finished");
    }
}
