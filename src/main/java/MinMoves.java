import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinMoves {

    public int minMoves(int[] nums, int limit) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length / 2; i++) {
            int sum = nums[i] + nums[nums.length - i - 1];
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while (iterator.hasNext()) {
            int tmp = iterator.next().getValue();
            sum += tmp;
            max = Math.max(max, tmp);
        }
        return sum - max;
    }
}
