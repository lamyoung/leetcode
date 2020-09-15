import java.util.Arrays;

public class O39MajorityElement {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += nums[j] & 1;
                nums[j] = nums[j] >> 1;
            }
            if (count > nums.length / 2) {
                res += 1 << i;
            }
        }
        return res;
    }

    public int majorityElement3(int[] nums) {
        int tmp = 0;
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (count == 0) {
                tmp = nums[j];
            } else {
                if (tmp == nums[j]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return tmp;
    }
}
