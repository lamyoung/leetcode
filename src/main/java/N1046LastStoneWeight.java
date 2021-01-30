import java.util.Comparator;
import java.util.PriorityQueue;

public class N1046LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, (o1, o2) -> o2 - o1);
        for (int cur : stones) {
            queue.add(cur);
        }
        while (queue.size() >= 2) {
            int w2 = queue.poll();
            int w1 = queue.poll();
            if (w1 != w2) {
                queue.add(w2 - w1);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
