public class N0567CheckInConclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] one = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            one[s1.charAt(i) - 'a']++;
        }
        StringBuilder strOne = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (one[i] > 0) {
                strOne.append((char) ('a' + i)).append(one[i]);
            }
        }
        int[] two = new int[26];
        for (int i = 0; i < s1.length() - 1; i++) {
            two[s2.charAt(i) - 'a']++;
        }
        StringBuilder strTwo = new StringBuilder();
        for (int i = s1.length() - 1; i < s2.length(); i++) {
            two[s2.charAt(i) - 'a']++;
            for (int j = 0; j < 26; j++) {
                if (two[j] > 0) {
                    strTwo.append((char) ('a' + j)).append(two[j]);
                }
            }
            if (strOne.toString().equals(strTwo.toString())) {
                return true;
            }
            strTwo.delete(0, strTwo.length());
            two[s2.charAt(i - s1.length() + 1) - 'a']--;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] one = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            one[s1.charAt(i) - 'a']++;
            one[s2.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int j = 0; j < 26; j++) {
            if (one[j] != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - s1.length()) - 'a';
            if (x == y) {
                continue;
            }
            if (one[x] == 0) {
                diff++;
            }
            one[x]--;
            if (one[x] == 0) {
                diff--;
            }
            if (one[y] == 0) {
                diff++;
            }
            one[y]++;
            if (one[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "edibaooo";
        N0567CheckInConclusion c = new N0567CheckInConclusion();
        System.out.println(c.checkInclusion2(s1, s2));
    }
}
