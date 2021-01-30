import java.util.HashMap;

public class N1658_2MinOperations {

    public static int minOperations(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num += nums[i];
            map.put(num, i + 1);
        }
        int sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (x == sum) {
                min = Math.min(min, nums.length - 1 - i);
                break;
            }
            if (x < sum) {
                break;
            }
            if (map.containsKey(x - sum)) {
                min = Math.min(min, map.get(x - sum) + nums.length - 1 - i);
                sum += nums[i];
                continue;
            }
            sum += nums[i];
        }
        if (min > nums.length) {
            return -1;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1};
        int x = 3;
        System.out.println(minOperations(arr, x));
    }
}
