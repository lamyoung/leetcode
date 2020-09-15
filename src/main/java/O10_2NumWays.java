public class O10_2NumWays {

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 2; i < n; i++) {
            pre2 = pre2 + pre1;
            pre1 = pre2 - pre1;
            if (pre2 > 1000000007) {
                pre2 -= 1000000007;
            }
        }
        return pre2;
    }
}
