import java.util.Arrays;

public class MintSize {

	public static void main(String[] args) {
		int[] a = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(mintSize(a));
	}
	public static int mintSize(int[] arr) {
		int[] can = new int[100001];
		for (int i = 0; i < arr.length; i++) {
			can[arr[i]]++;
		}

		Arrays.sort(can);
		int count = 0;
		for (int i = can.length-1; i >= can.length-arr.length / 2; i--) {
			count += can[i];
			if (count >= arr.length / 2) {
				return can.length-i;
			}
		}
		return arr.length/2;
	}
}
