import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class O27MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            TreeNode tmpLeft = tmp.left;
            tmp.left = tmp.right;
            tmp.right = tmpLeft;
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return root;
    }

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return root;
    }

    public void dfs(TreeNode tmp) {
        TreeNode tmpLeft = tmp.left;
        tmp.left = tmp.right;
        tmp.right = tmpLeft;
        if (tmp.left != null) {
            dfs(tmp.left);
        }
        if (tmp.right != null) {
            dfs(tmp.right);
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
