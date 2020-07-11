/**
 * @author lam young
 * @Description
 * @create 2020/7/10 23:43
 */
public class N371GetSum {

	public int getSum(int a, int b) {
		while(a>0) {
			int high = (a&b)<<1;
			b = a^b;
			a = high;
		}
		return b;
	}

	return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
}
