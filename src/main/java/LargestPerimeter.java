public class LargestPerimeter {

	public int largestPerimeter(int[] A) {
		int count = 0;
		for (int i = A.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (A[j] > A[j + 1]) {
					A[j] += A[j + 1];
					A[j + 1] = A[j] - A[j + 1];
					A[j] = A[j] - A[j + 1];
				}
			}
			if (count < 2) {
				count++;
			} else {
				if (A[i] + A[i + 1] > A[i + 2]) {
					return A[i] + A[i + 1] + A[i + 2];
				}
			}
		}
		return 0;
	}
}
