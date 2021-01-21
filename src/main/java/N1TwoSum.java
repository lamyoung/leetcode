import java.util.HashMap;
import java.util.HashSet;

public class N1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.get(target-nums[i]) != null) {
                res[0] = i;
                res[1] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
