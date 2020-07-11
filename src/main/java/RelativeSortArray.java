public class RelativeSortArray {

	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int[] tmp = new int[1001];
		int[] res = new int[arr1.length];
		int pos = 0;
		for(int arr:arr1) {
			tmp[arr]++;
		}
		for(int arr:arr2) {
			while(tmp[arr]>0) {
				res[pos] = arr;
				pos++;
				tmp[arr]--;
			}
		}
		for(int i=0; i<tmp.length; i++) {
			while(tmp[i]>0) {
				res[pos] = i;
				pos++;
				tmp[i]--;
			}
		}
		return res;
	}
}
