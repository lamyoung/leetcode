/**
 * @author lam young
 * @Description
 * @create 2020/7/2 22:57
 */
public class N191HammingWeight {

	public int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				count++;
			}
			n = n >> 1;
			if(n==0) {
				break;
			}
		}
		return count;
	}

	public static int hammingWeight2(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				count++;
			}
			n /= 2;
		}
		return count;
	}

	public static void main(String[] args) {
		int res = hammingWeight2(-11);
		System.out.println(res);
	}
}
