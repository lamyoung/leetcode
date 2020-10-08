import java.util.ArrayList;
import java.util.List;

public class O34PathSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    int tmpSum = 0;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (tmpSum + root.val == sum && root.left == null && root.right == null) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(tmp);
            tmpList.add(root.val);
            res.add(tmpList);
            return;
        }
        tmp.add(root.val);
        tmpSum += root.val;
        dfs(root.left, sum);
        dfs(root.right, sum);
        tmp.remove(tmp.size() - 1);
        tmpSum -= root.val;
        return;
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
