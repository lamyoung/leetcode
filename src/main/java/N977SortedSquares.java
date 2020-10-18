public class N977SortedSquares {

    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) {
            return A;
        }
        int pre = 0;
        int last = A.length - 1;
        int[] res = new int[A.length];
        for (int i = res.length - 1; i >= 0; i--) {
            if (Math.abs(A[pre]) > Math.abs(A[last])) {
                res[i] = A[pre] * A[pre];
                pre++;
            } else {
                res[i] = A[last] * A[last];
                last--;
            }
        }
        return res;
    }
}
