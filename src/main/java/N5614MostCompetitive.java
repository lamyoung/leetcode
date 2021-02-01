import java.util.Arrays;
import java.util.Stack;

public class N5614MostCompetitive {

    public int[] mostCompetitive(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        int min = Integer.MAX_VALUE;
        int[] minNums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            minNums[i] = min;
        }

        int[] res = new int[k];
        int limit = 0;
        for (int i = 0; i < k; i++) {
            int limitLast = nums.length - k + i + 1;
            int tmpRes = Integer.MAX_VALUE;
            for (int j = limit; j < limitLast; j++) {
                if (nums[j] < tmpRes) {
                    limit = j + 1;
                    tmpRes = nums[j];
                }
                if (tmpRes == minNums[j]) {
                    break;
                }
            }
            res[i] = tmpRes;
        }
        return res;
    }

    public int[] mostCompetitive2(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && nums.length - i > k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.add(nums[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        N5614MostCompetitive m = new N5614MostCompetitive();
        int[] num = new int[]{3,5,2,6};
        System.out.println(Arrays.toString(m.mostCompetitive2(num, 2)));
    }
}
