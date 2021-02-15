import java.util.ArrayList;
import java.util.List;

public class N0448FindDisappeareNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int cur : nums) {
            cur = cur > 0 ? cur : -cur;
            if (nums[cur - 1] > 0) {
                nums[cur - 1] = -nums[cur - 1];
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
