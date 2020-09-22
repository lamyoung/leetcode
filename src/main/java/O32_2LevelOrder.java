import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O32_2LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        int nextCount = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmpList = new ArrayList<>();
            while (count > 0) {
                TreeNode tmp = queue.poll();
                tmpList.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                    nextCount++;
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                    nextCount++;
                }
                count--;
            }
            res.add(tmpList);
            count = nextCount;
            nextCount = 0;
        }
        return res;
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
