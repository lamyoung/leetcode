public class LemonadeChange {

	public boolean lemonadeChange(int[] bills) {
		int num5 = 0, num10 = 0;
		for (int bill : bills) {
			if (bill == 5) {
				num5++;
			} else if (bill == 10) {
				if (num5 == 0) {
					return false;
				}
				num5--;
				num10++;
			} else if (bill == 20) {
				if (num5 == 0) {
					return false;
				} else if (num10 > 0) {
					num10--;
					num5--;
				} else if (num10 == 0 && num5 >= 3) {
					num5 -= 3;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
