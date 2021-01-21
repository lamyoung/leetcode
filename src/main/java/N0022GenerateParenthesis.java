import java.util.ArrayList;
import java.util.List;

public class N0022GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, n, n);
        return res;
    }

    private void dfs(List res, StringBuilder sb, int pre, int last) {
        if (pre == 0) {
            int len = sb.length();
            for (int i = 0; i < last; i++) {
                sb.append(")");
            }
            res.add(sb.toString());
            sb.delete(len, sb.length());
            return;
        }
        if (pre == last) {
            int len = sb.length();
            sb.append("(");
            dfs(res, sb, pre-1, last);
            sb.delete(len, sb.length());
        } else {
            int len = sb.length();
            sb.append("(");
            dfs(res, sb, pre-1, last);
            sb.delete(len, sb.length());
            sb.append(")");
            dfs(res, sb, pre, last-1);
            sb.delete(len, sb.length());
        }
    }

    public static void main(String[] args) {
        N0022GenerateParenthesis g = new N0022GenerateParenthesis();
        System.out.println(g.generateParenthesis(1));
    }
}
