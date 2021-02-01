import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC_2 {

    private volatile static int state = 0;

    public static class PrintChar implements Runnable {

        private char toPrint;
        private int condition;
        private Object lock;

        public PrintChar(Object lock, char toPrint, int condition) {
            this.toPrint = toPrint;
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (lock) {
                    if (state % 3 == condition) {
                        System.out.println(i + 1 + ":" + toPrint);
                        state++;
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        new Thread(new PrintChar(lock, 'A', 0)).start();
        new Thread(new PrintChar(lock, 'B', 1)).start();
        new Thread(new PrintChar(lock, 'C', 2)).start();
    }

}
