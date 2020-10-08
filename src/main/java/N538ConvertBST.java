import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class N538ConvertBST {

    public int count;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode res = root;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            count += root.val;
            root.val = count;
            root = root.left;
        }
        return res;
    }

    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        count += root.val;
        root.val = count;
        dfs(root.left);
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
