package MultiThreading.Ch4StopThread;

public class KillTheThread {
    public static void main(String[] args) {
        PortfolioVolatile portfolioThread = new PortfolioVolatile("Portfolio data");
        portfolioThread.start();



        int i = 0;
        do {
            System.out.println("i = " + i++);
        } while (i < 100);

        // kill the thread
        portfolioThread.stopMe();
    }
}

class PortfolioVolatile extends Thread {

    private volatile Thread stopMe;

    public PortfolioVolatile(String threadName) {
        super(threadName);
    }

    public void stopMe() {
        stopMe = null;
    }

    @Override
    public void run() {
        stopMe = Thread.currentThread();

        while (stopMe == Thread.currentThread()) {
            System.out.println("The Portfolio thread is running");
        }

        System.out.println("The Portfolio thread was killed");
    }
}

