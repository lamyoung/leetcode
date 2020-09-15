import sun.reflect.generics.tree.Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class O07BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        TreeNode root = new TreeNode(preorder[pstart]);
        int count = istart;
        while (inorder[count] != preorder[pstart]) {
            count++;
        }
        if (count - istart > 1) {
            root.left = build(preorder, pstart + 1, pstart + count - istart, inorder, istart, count - 1);
        } else if (count - istart == 1) {
            root.left = new TreeNode(inorder[istart]);
        }
        if (iend - count > 1) {
            root.right = build(preorder, pstart + count - istart + 1, pend, inorder, count + 1, iend);
        } else if (iend - count == 1) {
            root.right = new TreeNode(inorder[iend]);
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
