public class O56_1SingleNumber {

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int pos = 0;
        while ((res & 1) == 0) {
            pos++;
            res = res >> 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> pos) & 1) == 1) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        int[] re = new int[]{a, b};
        return re;
    }
}
