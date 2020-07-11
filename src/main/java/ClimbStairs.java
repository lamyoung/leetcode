public class ClimbStairs {

	public int climbStairs(int n) {
		return method(n);
	}

	public int method(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int one = 1;
		int two = 2;
		for (int i = 3; i <= n; i++) {
			two += one;
			one = two - one;
		}
		return two;
	}
}
