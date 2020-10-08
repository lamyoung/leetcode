public class O56_2SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            int index = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & index) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                res |= index;
            }
        }
        return res;
    }
}
