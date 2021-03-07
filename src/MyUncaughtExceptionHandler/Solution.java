package MyUncaughtExceptionHandler;

public class Solution {

    // создаем наш обработчик
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {

        // в конструкторе нити указываем созданный нами обработчик
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            // setUncaughtExceptionHandler - это будет обработчик исключений, специфичный для потока.
            // Таким образом, если этот поток будет завершен каким-то необработанным исключением,
            // будет использован этот обработчик.

            // setDefaultUncaughtExceptionHandler - это будет обработчик исключений по умолчанию в случае,
            // если нет специального обработчика неперехваченных исключений для потока.
            setDefaultUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    //Создаем класс для нашего обработчика исключений
    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}
