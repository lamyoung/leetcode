public class FindNumbers {
	public int findNumbers(int[] nums) {
		int count = 0;
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0) {
				continue;
			}
			int tmp = 0;
			while(nums[i]>0) {
				nums[i] /= 10;
				tmp++;
			}
			if(tmp%2==0) {
				count++;
			}
		}
		return count;
	}
}
