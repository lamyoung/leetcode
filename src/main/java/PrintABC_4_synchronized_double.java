public class PrintABC_4_synchronized_double {

    public static class Print implements Runnable {

        private Object prev;
        private Object self;
        private String toPrint;

        public Print(Object prev, Object self, String toPrint) {
            this.prev = prev;
            this.self = self;
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (prev) {
                    synchronized (self) {
                        System.out.println(i + 1 + ":" + toPrint);
                        self.notify();
                    }
                    try {
                        if (i < 9) {
                            prev.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new Print(c, a, "A")).start();
        Thread.sleep(10);
        new Thread(new Print(a, b, "B")).start();
        Thread.sleep(10);
        new Thread(new Print(b, c, "C")).start();
    }

}
