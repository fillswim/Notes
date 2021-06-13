package MultiThreading.Ch6ExecutorFramework;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TestCallableThread {
    public static void main(String[] args) {
        Callable<Integer> callable1 = () -> {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Thread 1 is running " + i);
            }
            return 123;
        };

        Callable<Integer> callable2 = () -> {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(700);
                System.out.println("Thread 2 is running " + i);
            }
            return 456;
        };

        ArrayList<Future<Integer>> futures = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();

        final ExecutorService service = Executors.newFixedThreadPool(2);

        try {
            futures.add(service.submit(callable1));
            futures.add(service.submit(callable2));

            for (Future<Integer> future : futures) {
                results.add(future.get());
            }

        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

        for (Integer integer : results) {
            System.out.println("Results: " + integer);
        }
    }
}
