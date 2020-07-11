/**
 * @author lam young
 * @Description
 * @create 2020/7/10 23:11
 */
public class N342IsPowerOfFour {

	public boolean isPowerOfFour(int num) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((num & 1) != 0) {
				if((i&1)==1) {
					return false;
				}
				count++;
			}
			if(count>1) {
				return false;
			}
			num = num >> 1;
			if (num == 0) {
				break;
			}
		}
		return count==1;
	}
}
