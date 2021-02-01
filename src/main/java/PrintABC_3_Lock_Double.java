import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC_3_Lock_Double {

    public static class Print implements Runnable {

        private Lock lock;
        private Condition pre;
        private Condition self;
        private String toPrint;

        public Print(Lock lock, Condition pre, Condition self, String toPrint) {
            this.pre = pre;
            this.self = self;
            this.lock = lock;
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    System.out.println(i + 1 + ":" + toPrint);
                    self.signal();
                    if (i < 9) {
                        pre.await();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        new Thread(new Print(lock, a, b, "A")).start();
        Thread.sleep(10);
        new Thread(new Print(lock, b, c, "B")).start();
        Thread.sleep(10);
        new Thread(new Print(lock, c, a, "C")).start();
    }

}
