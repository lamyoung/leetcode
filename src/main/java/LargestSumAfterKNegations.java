public class LargestSumAfterKNegations {

	public int largestSumAfterKNegations(int[] A, int K) {
		int[] tmp = new int[201];
		for (int a : A) {
			tmp[a + 100]++;
		}
		for (int i = 0; i < 100; i++) {
			if (K > 0) {
				while (K > 0 && tmp[i] > 0) {
					K--;
					tmp[i]--;
					tmp[200 - i]++;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < 201; i++) {
			sum += (tmp[i] * (i - 100));
		}
		// 没用完，奇数，没有0，必须反转一个正数
		if (((K & 1) == 1) && tmp[100] == 0) {
			int j = 101;
			while (tmp[j] == 0) {
				j++;
			}
			sum -= (2 * j - 200);
		}
		return sum;
	}
}
