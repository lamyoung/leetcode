public class BalanceStringSplit {

	public int balancedStringSplit(String s) {

		if(s.length()==0) {
			return 0;
		}
		int i=1;
		char tmpChar = s.charAt(0);
		int tmpCount = 1;
		int count = 0;
		while(i<s.length()) {
			if(s.charAt(i) == tmpChar) {
				tmpCount++;
			} else {
				tmpCount--;
			}
			i++;
			if(tmpCount==0) {
				count++;
				if(i<s.length()) {
					tmpChar = s.charAt(i);
				}
			}
		}
		return count;
	}
}
