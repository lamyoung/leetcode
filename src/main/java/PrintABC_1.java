import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC_1 {

    private volatile static int state = 0;

    public static class PrintChar implements Runnable {

        private char toPrint;
        private int condition;
        private Lock lock;

        public PrintChar(Lock lock, char toPrint, int condition) {
            this.toPrint = toPrint;
            this.condition = condition;
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                try {
                    lock.lock();
                    if (state % 3 == condition) {
                        System.out.println(i + 1 + ":" + toPrint);
                        state++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Thread(new PrintChar(lock, 'A', 0)).start();
        new Thread(new PrintChar(lock, 'B', 1)).start();
        new Thread(new PrintChar(lock, 'C', 2)).start();
    }

}
