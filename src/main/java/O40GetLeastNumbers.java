import java.util.Arrays;

public class O40GetLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k) {
        int pos = arr.length - 1;
        int mark = pos;
        for (int i = 0; i < k; i++) {
            boolean flag = true;
            for (int j = 0; j < pos; j++) {
                if (arr[j] < arr[j + 1]) {
                    mark = j;
                    arr[j] += arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    flag = false;
                }
            }
            pos = mark;
            if (flag) {
                break;
            }
            if (arr.length - 1 - pos >= k) {
                break;
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[arr.length - 1 - i];
        }
        return res;
    }

    public static int[] getLeastNumbers2(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        getLeastNumbers2(num, k);
    }
}
