import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N40CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            if(candidates[i]>target) {
                continue;
            }
            if(candidates[i]==target) {
                List<Integer> resTmp = new ArrayList<>();
                resTmp.add(candidates[i]);
                res.add(resTmp);
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            tmp.add(candidates[i]);
            combination(candidates[i], target, candidates, i+1, res, tmp);
        }
        return res;
    }

    private static void combination(int sum, int target, int[] candidates, int pos, List<List<Integer>> res, List<Integer> tmp) {
        if (pos > candidates.length - 1) {
            return;
        }
        sum += candidates[pos];
        if (sum == target) {
            tmp.add(candidates[pos]);
            List<Integer> resTmp = new ArrayList<>();
            for (int i = 0; i < tmp.size(); i++) {
                resTmp.add(tmp.get(i));
            }
            res.add(resTmp);
            tmp.remove(tmp.size() - 1);
        }
        if (sum < target) {
            tmp.add(candidates[pos]);
            combination(sum, target, candidates, pos + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
        sum -= candidates[pos];
        combination(sum, target, candidates, pos + 1, res, tmp);
    }

    public static void main(String[] args) {
        int[] candinates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candinates, target);
    }
}
