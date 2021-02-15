import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class N0119GetRow {

    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            res[i] = 1;
            for (int j = i - 1; j >= 1; j--) {
                res[j] += res[j - 1];
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        N0119GetRow g = new N0119GetRow();
        System.out.println(g.getRow(0));
    }
}
