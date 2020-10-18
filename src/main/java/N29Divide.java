public class N29Divide {

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? true : false;
        dividend = dividend < 0 ? -dividend : dividend;
        divisor = divisor < 0 ? -divisor : divisor;
        if (divisor > dividend) {
            return 0;
        }
        int last = 1;
        int start = divisor;
        while (divisor < dividend) {
            divisor = divisor << 1;
            last = last << 1;
        }
        int pre = 1;
        int end = divisor;
        while (start < end) {
            int tmp = (start + end) >> 1;
            int count = (pre + last) >> 1;
            if (dividend == tmp) {
                return flag ? count : -count;
            } else if (dividend > tmp) {
                start = tmp;
                pre = count;
            } else {
                end = tmp;
                last = count;
            }
        }
        System.out.println(pre);
        return flag ? pre : -pre;
    }

    public static void main(String[] args) {
        System.out.println(divide(2147483647, 1));
    }
}
