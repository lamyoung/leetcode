import java.util.PriorityQueue;

public class N0703KthLargest {

    PriorityQueue<Integer> queue;
    int size;

    public N0703KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        size = k;
        for (int cur : nums) {
            addNum(cur);
        }
    }

    public int add(int val) {
        return addNum(val);
    }

    private int addNum(int val) {
        if (queue.size() < size) {
            queue.offer(val);
        } else {
            if (val > queue.peek()) {
                queue.poll();
                queue.add(val);
            }
        }
        return queue.peek();
    }
}
