public class N0509Fib {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 2, 1, 1);
    }

    private int fib(int n, int first, int second) {
        if (n > 0) {
            return fib(--n, second, first + second);
        } else {
            return second;
        }
    }

    public static void main(String[] args) {
        N0509Fib f = new N0509Fib();
        System.out.println(f.fib(1));
        System.out.println(f.fib(2));
        System.out.println(f.fib(3));
        System.out.println(f.fib(4));
        System.out.println(f.fib(5));
    }
}
