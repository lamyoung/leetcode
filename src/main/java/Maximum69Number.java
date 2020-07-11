public class Maximum69Number {

	public int maximum69Number(int num) {
		int count = 0;
		int flag = -1;
		for (int i = num; i > 0; i /= 10) {
			if (i % 10 == 6) {
				flag = count;
			}
			count++;
		}
		if (flag >= 0) {
			return num + 3 * (int) Math.pow(10, flag);
		} else {
			return num;
		}
	}
}
