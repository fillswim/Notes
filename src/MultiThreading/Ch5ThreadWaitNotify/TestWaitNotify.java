package MultiThreading.Ch5ThreadWaitNotify;

public class TestWaitNotify {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.someMethod();
    }
}

class ClassA {
    void someMethod() {
        ThreadB threadB = new ThreadB(this);
        Thread thread = new Thread(threadB, "Thread B");
        thread.start();

        synchronized (this) {
            try {
                // Выполнение методы засыпает на максимум 10 секунд,
                // если не придет уведомление раньше этого срока
                wait(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The main thread is finished");
    }
}

class ThreadB implements Runnable {
    final ClassA classA;

    public ThreadB(ClassA classA) {
        this.classA = classA;
    }

    @Override
    public void run() {
        try {
            // Thread "B" выполняется за 5 секунд и
            // будет метод класса A раньше срока его пробуждения
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println(i + " sec");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread \"B\" finished");

        synchronized (classA) {
            classA.notify();
            System.out.println("Notice main thread");
        }
    }
}
