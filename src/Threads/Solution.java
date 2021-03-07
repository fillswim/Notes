package Threads;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        // Создание нити из класса унаследованного от класса Thread
        ThreadExtendsThread thread_1 = new ThreadExtendsThread();

        // Создание нити из класса реализующего интерфейс Runnable
        ThreadImplRunnable threadImplRunnable = new ThreadImplRunnable();
        Thread thread_2 = new Thread(threadImplRunnable);

        //Одновременный запуск выполнения нитей
        thread_1.start();
        thread_2.start();

        //остановить нитей через 5 сек.
        Thread.sleep(5000);
        thread_1.interrupt();
        thread_2.interrupt();
    }
}
