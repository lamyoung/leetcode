public class O53_2MissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]++;
        }
        for (int i = 0; i < nums.length; i++) {
            int abs = nums[i] > 0 ? nums[i] : -nums[i];
            if (abs == nums.length + 1) {
                continue;
            }
            nums[abs - 1] = -nums[abs - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums.length) {
                tmp[nums[i]]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (tmp[i] == 0) {
                return i;
            }
        }
        return nums.length;
    }
}
