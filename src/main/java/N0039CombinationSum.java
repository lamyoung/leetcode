import java.util.ArrayList;
import java.util.List;

public class N0039CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        dfs(res, cur, candidates, 0, target);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[] candidates, int idx, int target) {
        if (idx > candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (target < candidates[idx]) {
            return;
        }
        dfs(res, cur, candidates, idx + 1, target);
        cur.add(candidates[idx + 1]);
        dfs(res, cur, candidates, idx + 1, target - candidates[idx]);
        cur.remove(cur.size() - 1);
    }
}
