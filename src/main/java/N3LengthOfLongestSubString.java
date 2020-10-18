import java.util.HashMap;
import java.util.HashSet;

public class N3LengthOfLongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        HashSet<Character> set = new HashSet<>();
        int pre = 0;
        set.add(s.charAt(0));
        int count = 1;
        int max = count;
        int after = 1;
        while (after < s.length()) {
            char tmp = s.charAt(after);
            if (!set.contains(tmp)) {
                set.add(tmp);
                count++;
                max = Math.max(max, count);
            } else {
                while (tmp != s.charAt(pre)) {
                    set.remove(s.charAt(pre));
                    pre++;
                    count--;
                }
                pre++;
            }
            after++;
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
