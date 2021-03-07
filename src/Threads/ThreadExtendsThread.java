package Threads;

public class ThreadExtendsThread extends Thread{
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        int timer = 0;
        while (!current.isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Нить " +getName() + " остановлена");
                break;
            }
            timer++;
            System.out.println("Нить " +getName() + " работает "  + timer +" сек.");
        }
    }
}
