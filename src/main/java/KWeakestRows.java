import java.util.Arrays;
import java.util.Comparator;

public class KWeakestRows {

	public int[] kWeakestRows(int[][] mat, int k) {
		int[][] cal = new int[mat.length][2];
		for (int i = 0; i < mat.length; i++) {
			cal[i][0] = i;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					cal[i][1]++;
				} else {
					break;
				}
			}
		}
		Arrays.sort(cal, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = cal[i][0];
		}
		return res;
	}
}
