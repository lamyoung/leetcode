import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N0989AddToArrayForm {

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int i = A.length - 1;
        int plus = 0;
        while (i >= 0 || K > 0) {
            int add = K % 10;
            int sum;
            if(i>=0) {
                sum = A[i] + add + plus;
            } else {
                sum = add + plus;
            }
            res.add(sum % 10);
            plus = sum / 10;
            i--;
            K /= 10;
        }
        if (plus != 0) {
            res.add(plus);
        }
        Collections.reverse(res);
        return res;
    }
}
