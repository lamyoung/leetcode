public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int i=0;
		int j=0;
		for(; i<s.length(); i++) {
			for(; j<t.length(); j++) {
				if(s.charAt(i)==t.charAt(j)) {
					j++;
					break;
				}
			}
			if(j==t.length()) {
				i++;
				break;
			}
		}
		return i==s.length();
	}
}
