import java.util.HashMap;

public class N0922SubArraysWithKDistinct {

    public int subarraysWithKDistinct(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<>(A.length);
        int res = 0;
        for (int i = 0; i < K; i++) {
            int num = map.getOrDefault(A[i], 0);
            map.put(A[i], num + 1);
        }
        if (map.size() == K) {
            res++;
        }
        int start = 0;
        int end = K;
        while (end < A.length) {
            int num = map.getOrDefault(A[end], 0);
            map.put(A[end], num + 1);
            if (map.size() == K) {
                res++;
                end++;
                continue;
            }
            while (map.size() > K) {
                num = map.get(A[start]);
                if (num > 1) {
                    map.put(A[start], num - 1);
                } else {
                    map.remove(A[start]);
                }
                start++;
            }
            if (map.size() == K) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 1, 2, 3};
        N0922SubArraysWithKDistinct s = new N0922SubArraysWithKDistinct();
        System.out.println(s.subarraysWithKDistinct(arr, 2));
    }
}
