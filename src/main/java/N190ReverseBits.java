/**
 * @author lam young
 * @Description
 * @create 2020/6/23 0:02
 */
public class N190ReverseBits {

	public int reverseBits(int n) {
		int res = 0;
		for(int i=0; i<32; i++) {
			res += (n>>i)^1<<i;
		}
		return res;
	}
}
