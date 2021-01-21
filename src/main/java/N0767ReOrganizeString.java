public class N0767ReOrganizeString {

    public String reorganizeString(String S) {
        char[] tmp = new char[26];
        for (char c : S.toCharArray()) {
            tmp[c - 97]++;
        }
        int len = (S.length() + 1) / 2;
        boolean flag = false;
        char c = 'a';
        for (int i = 0; i < 26; i++) {
            if (tmp[i] > len) {
                return "";
            }
            if (tmp[i] == len && (S.length() & 1) == 1) {
                flag = true;
                c = (char) (i - 97);
            }
        }
        char[] res = new char[S.length()];
        int pos = 0;
        if (flag) {
            for (int i = 0; i < res.length; i += 2) {
                res[i] = c;
                tmp[c - 97]--;
            }
        } else {
            for (int i = 0; i < res.length; i += 2) {
                while (tmp[pos] == 0) {
                    pos++;
                }
                res[i] = (char) (97 + pos);
                tmp[pos]--;
            }
        }
        for (int i = 1; i < res.length; i += 2) {
            while (tmp[pos] == 0) {
                pos++;
            }
            res[i] = (char) (97 + pos);
            tmp[pos]--;
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        N0767ReOrganizeString r = new N0767ReOrganizeString();
        System.out.println(r.reorganizeString("aab"));
    }
}
