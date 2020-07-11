public class RemovePalindromeSub {

	int count;

	public int removePalindromeSub(String s) {
		count = 0;
		for (int i = s.length(); i > 0; ) {
			s = remove(s, i);
			i--;
			if (i > s.length()) {
				i = s.length();
			}
		}
		return count;
	}

	public String remove(String s, int palindromeLength) {
		for (int i = 0; i <= s.length() - palindromeLength; i++) {
			if (isPalindrome(s.substring(i, i + palindromeLength))) {
				count++;
				return s.substring(0, i) + s.substring(i + palindromeLength);
			}
		}
		return s;
	}

	public boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
