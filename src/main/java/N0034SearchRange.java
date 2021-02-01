import java.util.Arrays;

public class N0034SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = 0, end = nums.length;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[mid] != target) {
            return new int[]{-1, -1};
        }
        int left = mid, right = mid;
        if (mid > 0 && nums[mid - 1] == target) {
            left = searchLeft(nums, target, 0, mid);
        }
        if (right < nums.length - 1 && nums[mid + 1] == target) {
            right = searchRight(nums, target, mid, nums.length);
        }
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target, int start, int end) {
        int res = end;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                res = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    private int searchRight(int[] nums, int target, int start, int end) {
        int res = start;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        N0034SearchRange s = new N0034SearchRange();
        int[] num = new int[]{5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10};
        System.out.println(Arrays.toString(s.searchRange(num, 5)));
    }
}
