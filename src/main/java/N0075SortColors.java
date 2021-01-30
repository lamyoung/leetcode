public class N0075SortColors {

    public void sortColors(int[] nums) {
        int pre = 0, last = nums.length - 1;
        while (pre < last) {
            while (nums[last] == 2 && last > pre) {
                last--;
            }
            while (nums[pre] != 2 && last > pre) {
                pre++;
            }
            if (pre < last) {
                nums[pre] += nums[last];
                nums[last] = nums[pre] - nums[last];
                nums[pre] = nums[pre] - nums[last];
            }
        }
        pre = 0;
        last = nums[last] == 2 ? last - 1 : last;
        while (pre < last) {
            while (nums[last] == 1 && last > pre) {
                last--;
            }
            while (nums[pre] == 0 && last > pre) {
                pre++;
            }
            if (pre < last) {
                nums[pre] += nums[last];
                nums[last] = nums[pre] - nums[last];
                nums[pre] = nums[pre] - nums[last];
            }
        }
        for (int tmp : nums) {
            System.out.println(tmp);
        }
    }

    public static void main(String[] args) {
        N0075SortColors s = new N0075SortColors();
        int[] arr = new int[]{0};
        s.sortColors(arr);
    }
}
