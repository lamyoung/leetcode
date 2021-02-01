import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class N0239MaxSLidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> maxElements = new LinkedList<Integer>();
        for (int i = 0; i < k; i++) {
            while (!maxElements.isEmpty() && maxElements.peekFirst() < nums[i]) {
                maxElements.pollFirst();
            }
            maxElements.addFirst(nums[i]);
        }
        res[0] = maxElements.peekLast();
        for (int i = k; i < nums.length; i++) {
            if (nums[i - k] == maxElements.peekLast()) {
                maxElements.pollLast();
            }
            while (!maxElements.isEmpty() && maxElements.peekFirst() < nums[i]) {
                maxElements.pollFirst();
            }
            maxElements.addFirst(nums[i]);
            res[i - k + 1] = maxElements.peekLast();
        }
        return res;
    }
}
