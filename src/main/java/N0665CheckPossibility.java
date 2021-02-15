import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class N0665CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                if (i == 1) {
                    flag = true;
                    max = nums[i];
                    continue;
                }
                count++;
                if (flag || count > 1) {
                    return false;
                }
            } else {
                max = nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N0665CheckPossibility c = new N0665CheckPossibility();
        int[] arr = new int[]{5, 7, 1, 8};
        System.out.println(c.checkPossibility(arr));
    }
}
