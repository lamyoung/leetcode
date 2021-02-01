import java.util.Arrays;

public class N1657CloseStrings {
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] res1 = getCount(word1);
        int[] res2 = getCount(word2);
        for (int i = 0; i < res1.length; i++) {
            if ((res1[i] == 0 && res2[i] != 0) || (res1[i] != 0 && res2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(res1);
        Arrays.sort(res2);
        for (int i = 0; i < res1.length; i++) {
            if (res1[i] != res2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getCount(String s) {
        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 97]++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "cabbba";
        String s2 = "aabbss";
        System.out.println(closeStrings(s1, s2));
    }
}
