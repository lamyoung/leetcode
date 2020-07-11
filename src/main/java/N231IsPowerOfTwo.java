/**
 * @author lam young
 * @Description
 * @create 2020/7/4 22:21
 */
public class N231IsPowerOfTwo {
	public boolean isPowerOfTwo(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) != 0) {
				count++;
			}
			if(count>1) {
				return false;
			}
			n = n >> 1;
			if (n == 0) {
				break;
			}
		}
		return count==1;
	}
}
