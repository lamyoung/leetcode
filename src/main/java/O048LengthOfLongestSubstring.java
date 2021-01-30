import java.util.Arrays;

public class O048LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] mark = new int[128];
        Arrays.fill(mark, -1);
        int max = 0;
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 0;
            if (mark[tmp] != -1 && mark[tmp] >= pre) {
                pre = mark[tmp] + 1;
            } else {
                max = Math.max(max, i - pre + 1);
            }
            mark[tmp] = i;
        }
        return max;
    }
}
