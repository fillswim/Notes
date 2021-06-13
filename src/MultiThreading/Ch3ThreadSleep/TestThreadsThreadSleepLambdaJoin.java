package MultiThreading.Ch3ThreadSleep;

import static java.lang.Thread.sleep;

public class TestThreadsThreadSleepLambdaJoin {
    public static void main(String[] args) {

        Runnable mn = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sleep(1000);
                    System.out.println("The market is improving " + i);
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + e.getMessage());
            }

            System.out.println("The stock market is improving!");
        };

        Runnable pf = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    sleep(700);
                    System.out.println("You have " + (500 + i) + " shapes of IBM");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + e.getMessage());
            }
        };

        Thread marketNews = new Thread(mn, "Market News");
        Thread portfolio = new Thread(pf, "Portfolio data");

        marketNews.start();
        portfolio.start();

        // Thread marketNews и Thread portfolio "цепляются" к Thread main,
        // и как только они закончатся, только тогда main продолжит выполняться дальше
        try {
            marketNews.join();
            portfolio.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("TestThreads is finished");
    }
}
