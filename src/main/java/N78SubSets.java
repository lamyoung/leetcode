import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class N78SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        res.add(deepCopy(tmp));
        dfs(nums, 0, tmp, res);
        return res;
    }

    public void dfs(int[] nums, int count, List<Integer> tmp, List<List<Integer>> res) {
        if (count > nums.length - 1) {
            return;
        }
        dfs(nums, count + 1, tmp, res);
        tmp.add(nums[count]);
        res.add(deepCopy(tmp));
        dfs(nums, count + 1, tmp, res);
        tmp.remove(tmp.size() - 1);
    }

    public List<Integer> deepCopy(List<Integer> src) {
        List<Integer> dest = new ArrayList<>();
        dest.addAll(src);
        return dest;
    }
}
