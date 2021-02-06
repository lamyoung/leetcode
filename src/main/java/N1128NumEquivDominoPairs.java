import java.util.HashMap;

public class N1128NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] cur : dominoes) {
            int key = cur[0] < cur[1] ? cur[0] * 10 + cur[1] : cur[1] * 10 + cur[0];
            int num = map.getOrDefault(key, 0);
            res += num;
            map.put(key, num + 1);
        }
        return res;
    }
}
