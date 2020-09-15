public class N389FindTheDifference {

    public static char findTheDifference(String s, String t) {
        int res = t.charAt(0);
        for(int i=1; i<t.length(); i++) {
            res ^= (t.charAt(i)^s.charAt(i-1));
        }
        return (char)res;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("bcde", "abcde"));
    }
}
