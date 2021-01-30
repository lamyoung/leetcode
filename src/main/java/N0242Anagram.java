public class N0242Anagram {

    public boolean isAnagram(String s, String t) {
//        if (s == null || t == null || s.length() != t.length()) {
//            return false;
//        }
//        int[] tmp = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            tmp[s.charAt(i) - 97] += 1;
//            tmp[t.charAt(i) - 97] -= 1;
//        }
//        for (int i = 0; i < tmp.length; i++) {
//            if (tmp[i] != 0) {
//                return false;
//            }
//        }
//        return true;
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int sint = 0;
        int tint = 0;
        for (int i = 0; i < s.length(); i++) {
            sint |= 1 << (s.charAt(i) - 97);
            tint |= 1 << (t.charAt(i) - 97);
        }
        return sint == tint;
    }
}
