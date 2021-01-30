import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class N0056Merge {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            queue.add(intervals[i]);
        }
        ArrayList<int[]> res = new ArrayList<>();
        int[] pre = queue.poll();
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] <= pre[1]) {
                pre[1] = Math.max(pre[1], cur[1]);
            } else {
                res.add(pre);
                pre = cur;
            }
        }
        res.add(pre);
        return res.toArray(new int[res.size()][]);
    }
}
