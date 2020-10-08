public class O44FindNthDigit {

    public static int findNthDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int init = 9;
        int num = 0;
        int count = 1;
        while (num < n) {
            num += init;
            init *= 10;
            count ++;
        }
        count--;
        num -= init/10;
        int count2 = 0;
        while(num < n) {
            num += count;
            count2++;
        }
        count2--;
        int res = 10^(count-1)-1+count2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(205));
    }
}
