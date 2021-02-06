import java.util.ArrayDeque;
import java.util.Deque;

public class N0098IsValidBST {

    public static void main(String[] args) {
        System.out.println();
    }
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        double cur = Double.MIN_VALUE;
        while (!deque.isEmpty() || root != null) {
            while (root != null) {
                deque.addFirst(root);
                root = root.left;
            }
            root = deque.pop();
            if (root.val <= cur) {
                return false;
            }
            cur = root.val;
            root = root.right;
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
