import javafx.util.Pair;

public class N0055CanJump {

    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || i == 0) {
                if (i == nums.length - 1) {
                    return true;
                }
                int des = i + Math.abs(nums[i]);
                for (int j = i + 1; j <= des && j < nums.length; j++) {
                    if (j == nums.length - 1) {
                        return true;
                    }
                    if (nums[j] >= 0) {
                        nums[j] = -nums[j];
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        N0055CanJump n = new N0055CanJump();
        int[] i = new int[]{3, 0, 8, 2, 0, 0, 1};
        System.out.println(n.canJump(i));
    }
}
