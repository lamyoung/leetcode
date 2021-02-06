import java.util.BitSet;
import java.util.concurrent.Semaphore;

public class PrintABC_5_Semaphore {

    public static class Print implements Runnable {

        private Semaphore next;
        private Semaphore self;
        private String toPrint;

        public Print(Semaphore self, Semaphore next, String toPrint) {
            this.next = next;
            this.self = self;
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    self.acquire();
                    System.out.println(i + 1 + ":" + toPrint);
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);
        new Thread(new Print(a, b, "A")).start();
        new Thread(new Print(b, c, "B")).start();
        new Thread(new Print(c, a, "C")).start();
    }

}
