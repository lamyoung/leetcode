public class N5606GetSmallestString {

    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        int num = 27;
        for (int i = n - 1; i >= 0; ) {
            while (k - n < num - 2) {
                num--;
            }
            int tmp;
            if((num-2)==0) {
                tmp = i+1;
            } else {
                tmp = (k - n) / (num - 2);
            }
            char c = (char) (97 + num - 2);
            for (int t = 0; t < tmp; t++) {
                res[i] = c;
                i--;
                n--;
            }
            k = k - tmp * (num - 1);
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        N5606GetSmallestString n5 = new N5606GetSmallestString();
        int n = 3, k = 27;
        System.out.println(n5.getSmallestString(n, k));
    }
}
