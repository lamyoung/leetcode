public class N1658_1MinOperations {

    private static int min = 0;

    public static int minOperations(int[] nums, int x) {
        boolean res = dfs(0, nums.length - 1, nums, x);
        if (res) {
            return min;
        } else {
            return -1;
        }
    }

    private static boolean dfs(int start, int end, int[] nums, int x) {
        if (start > end) {
            return false;
        }
        if (x == nums[start] || x == nums[end]) {
            min++;
            return true;
        }
        int tmp = Math.max(nums[start], nums[end]);
        boolean res = false;
        if (x > tmp) {
            min++;
            if (tmp == nums[start]) {
                res = dfs(start + 1, end, nums, x - tmp);
            } else {
                res = dfs(start, end - 1, nums, x - tmp);
            }
            if (res) {
                return true;
            } else {
                min--;
            }
        }
        int tmp2 = Math.min(nums[start], nums[end]);
        if (x > tmp2) {
            min++;
            if (tmp2 == nums[start]) {
                res = dfs(start + 1, end, nums, x - tmp2);
            } else {
                res = dfs(start, end - 1, nums, x - tmp2);
            }
            if (res) {
                return true;
            } else {
                min--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int x = 3;
        System.out.println(minOperations(nums, x));
    }
}
