import java.util.LinkedList;
import java.util.Queue;

public class N404SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            if (left != null) {
                if (left.left == null && left.right == null) {
                    sum += left.val;
                } else {
                    queue.add(left);
                }
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return sum;
    }

    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        dfs(root, sum);
        return sum[0];
    }

    public void dfs(TreeNode root, int[] sum) {
        TreeNode left = root.left;
        if (left != null) {
            if (left.left == null && left.right == null) {
                sum[0] += left.val;
            } else {
                dfs(left, sum);
            }
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
