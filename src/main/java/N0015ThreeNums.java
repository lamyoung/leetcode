import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class N0015ThreeNums {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(0 - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[i] + nums[j])) {
                    int tmp = map.get(nums[i] + nums[j]);
                    if (i < tmp && j < tmp) {
                        List<Integer> resCur = new ArrayList<>();
                        resCur.add(nums[i]);
                        resCur.add(nums[j]);
                        resCur.add(nums[tmp]);
                        res.add(resCur);
                    }
                }
            }
        }
        return res;
    }
}
