public class N530GetMinimumDifference {

    private static int res = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        dfsMax(root);
        return res;
    }

    private static int dfsMax(TreeNode root) {
        if (root.left != null) {
            int tmp = root.val - dfsMax(root.left);
            res = Math.min(res, tmp);
        }
        if (root.right != null) {
            int tmp = dfsMin(root.right) - root.val;
            res = Math.min(res, tmp);
            return dfsMax(root.right);
        }
        return root.val;
    }

    private static int dfsMin(TreeNode root) {
        if (root.right != null) {
            int tmp = dfsMin(root.right) - root.val;
            res = Math.min(res, tmp);
        }
        if (root.left != null) {
            int tmp = root.val - dfsMax(root.left);
            res = Math.min(res, tmp);
            return dfsMin(root.left);
        }
        return root.val;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(334);
        TreeNode node2 = new TreeNode(277);
        TreeNode node3 = new TreeNode(507);
        TreeNode node4 = new TreeNode(285);
        TreeNode node5 = new TreeNode(678);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        System.out.println(getMinimumDifference(node1));
    }
}
