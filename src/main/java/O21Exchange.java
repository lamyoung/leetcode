public class O21Exchange {

    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while ((nums[start] & 1) == 1 && start < end) {
                start++;
                continue;
            }
            while ((nums[end] & 1) == 0 && start < end) {
                end--;
                continue;
            }
            if (start < end) {
                nums[start] += nums[end];
                nums[end] = nums[start] - nums[end];
                nums[start] = nums[start] - nums[end];
                start++;
                end--;
            }
        }
        return nums;
    }
}
