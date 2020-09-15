public class O16MyPower {

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double res = myPow(x, n / 2);
        double res2 = res * res;
        if ((n & 1) == 1) {
            if (n > 0) {
                return res2 * x;
            } else {
                return res2 / x;
            }

        } else {
            return res2;
        }
    }

    public static double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        long b = n;
        if (n < 0) {
            b = -b;
            x = 1 / x;
        }
        return pow(x, b);
    }

    public static double pow(double x, long n) {
        if (n == 1) {
            return x;
        }
        double res = pow(x, n / 2);
        double res2 = res * res;
        if ((n & 1) == 1) {
            return res2 * x;
        } else {
            return res2;
        }
    }

    public static void main(String[] args) {
        System.out.println(myPow2(1.00000,-2147483648));
    }
}
