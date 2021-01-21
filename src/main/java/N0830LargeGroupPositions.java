import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0830LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s == null || s.length() < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        int pre = 0;
        char cur = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == cur) {
                continue;
            }
            if (i - pre >= 3) {
                res.add(new ArrayList<>(Arrays.asList(pre, i - 1)));
            }
            pre = i;
            cur = s.charAt(i);
        }
        if (s.length() - pre >= 3) {
            res.add(new ArrayList<>(Arrays.asList(pre, s.length() - 1)));
        }
        return res;
    }
}
