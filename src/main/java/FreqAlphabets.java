public class FreqAlphabets {
	public String freqAlphabets(String s) {

		String mapString = "abcdefghijklmnopqrstuvwxyz";
		int tmp = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=s.length()-1; i>=0; i--) {
			tmp = 0;
			if(s.charAt(i) == '#') {
				i--;
				tmp += s.charAt(i)-'0';
				i--;
				tmp += 10*(s.charAt(i)-'0');
			} else {
				tmp = s.charAt(i)-'0';
			}
			sb.append(mapString.charAt(tmp-1));
		}
		return sb.reverse().toString();
	}
}
