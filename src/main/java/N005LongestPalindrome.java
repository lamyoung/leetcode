public class N005LongestPalindrome {

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        String res = "";
        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start; end < s.length(); end++) {
                if (start == end) {
                    dp[start][end] = 1;
                    if (max < 1) {
                        res = s.substring(start, end + 1);
                    }
                } else {
                    if (s.charAt(start) == s.charAt(end)) {
                        if (end - start == 1) {
                            dp[start][end] = 1;
                        } else {
                            dp[start][end] = dp[start + 1][end - 1];
                        }
                        if (dp[start][end] == 1) {
                            if (max < end - start + 1) {
                                max = end - start + 1;
                                res = s.substring(start, end + 1);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
