import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;

public class N0739DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[]{};
        }
        Deque<Integer> index = new LinkedList<>();
        index.addFirst(0);
        int[] res = new int[T.length];
        for (int i = 1; i < T.length; i++) {
            while (!index.isEmpty()) {
                int idx = index.peekFirst();
                if (T[i] > T[idx]) {
                    res[idx] = i - idx;
                    index.pollFirst();
                    continue;
                }
                break;
            }
            index.addFirst(i);
        }
        return res;
    }
}
