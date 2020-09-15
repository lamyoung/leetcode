public class O10_1Fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int pre1 = 1;
        int pre2 = 1;
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
