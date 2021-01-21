import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 10w线程，每个线程1w次，synchronized执行3分钟，CAS执行1分钟
 * 1w线程，每个线程10w次，synchronized执行1分15秒，CAS执行1分20秒
 * 1w线程，每个线程1w次，synchronized执行10s，CAS执行8秒
 * <p>
 * synchronized是可重入非公平锁，当增加次数而不增加线程数时，可能每个线程执行完一次后其他线程还没唤醒就又获得了锁
 * CAS操作在每个线程执行次数较多时性能显著比synchronized好
 * 打印日志可以发现CAS自旋次数并不多（不太准，写日志影响并发，尤其是在IDE的console里面写日志）
 */
public class N0547FIndCircleNum {

    private static volatile AtomicInteger number = new AtomicInteger(0);
    //private static volatile Integer number = 0;

    static class Modify implements Runnable {
        boolean flag = false;
        CountDownLatch latch;
        int count = 0;
        int sequence;

        public Modify(CountDownLatch latch, int sequence) {
            this.latch = latch;
            this.sequence = sequence;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100_000; i++) {
                while (!flag) {
                    int cur = number.get();
                    flag = number.compareAndSet(cur, cur + 1);
//                    synchronized (Modify.class) {
//                        number++;
//                    }
//                    flag = true;
                    count++;
                }
                // 写日志，会降低程序并发性，导致CAS自旋次数减少
                // 可以用来观察自旋，实际测试时需要注释掉
//                if (count > 1) {
//                    System.out.println(sequence + ":" + i + ":" + count);
//                }
                latch.countDown();
                flag = false;
                count = 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000_000_000);
        for (int i = 0; i < 10000; i++) {
            new Thread(new Modify(latch, i)).start();
        }
        latch.await();
        System.out.println(number);
    }
//    public int findCircleNum(int[][] isConnected) {
//        int size = isConnected.length;
//        int[][] visited = new int[size][size];
//        int res = 0;
//        for (int i = 0; i < size; i++) {
//            for (int j = i + 1; j < size; j++) {
//                if (visited[i][j] == 0) {
//                    res++;
//                    int pre = i;
//                    int last = j;
//                    while(isConnected[pre][last]==1) {
//
//                    }
//                }
//            }
//        }
//    }
}
