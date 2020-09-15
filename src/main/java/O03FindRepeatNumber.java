import java.util.BitSet;
import java.util.HashSet;

public class O03FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return 0;
    }

    public int findRepeatNumber2(int[] nums) {
        BitSet set = new BitSet(nums.length);
        for (int i=0; i<nums.length; i++) {
            if(set.get(nums[i])) {
                return nums[i];
            } else {
                set.set(nums[i]);
            }
        }
        return 0;
    }
}
