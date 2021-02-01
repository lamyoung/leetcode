import java.util.*;

public class N0347TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int cur : nums) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (queue.size() < k) {
                queue.add(new int[]{next.getKey(), next.getValue()});
                continue;
            }
            if (next.getValue() < queue.peek()[1]) {
                continue;
            }
            queue.poll();
            queue.add(new int[]{next.getKey(), next.getValue()});
        }
        return queue.stream().mapToInt(arr -> arr[0]).toArray();
    }
}
