public class N5605ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i2 = 0;
        int j2 = 0;
        for (int i = 0; i < word1.length; i++) {
            for (int j = 0; j < word1[i].length(); j++) {
                if (j2 >= word2[i2].length()) {
                    i2++;
                    j2 = 0;
                }
                if (i2 >= word2.length) {
                    return false;
                }
                if (word1[i].charAt(j) != word2[i2].charAt(j2)) {
                    return false;
                }
                j2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N5605ArrayStringsAreEqual n = new N5605ArrayStringsAreEqual();
        String[] a1 = new String[]{"ab", "c"};
        String[] a2 = new String[]{"a", "bc"};
        System.out.println(n.arrayStringsAreEqual(a1, a2));
    }
}
