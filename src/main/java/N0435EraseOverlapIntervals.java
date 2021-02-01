import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class N0435EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int res = 0;
        int preEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= preEnd) {
                preEnd = intervals[i][intervals[i].length - 1];
                continue;
            }
            if (intervals[i][intervals[i].length - 1] >= preEnd) {
                res++;
                continue;
            }
            res++;
            preEnd = intervals[i][intervals[i].length - 1];
        }
        return res;
    }
}
