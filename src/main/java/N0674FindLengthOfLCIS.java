public class N0674FindLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        int l = 0;
        int max = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] > nums[r - 1]) {
                continue;
            }
            max = Math.max(max, r - l);
            l = r;
        }
        max = Math.max(max, nums.length - l);
        return max;
    }
}
