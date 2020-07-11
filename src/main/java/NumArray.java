class NumArray {

	int[] sumNums;

	public NumArray(int[] nums) {
		sumNums = new int[nums.length+1];
		sumNums[0] = 0;
		for(int i=1; i<sumNums.length; i++) {
			sumNums[i] = sumNums[i-1]+nums[i-1];
		}
	}

	public int sumRange(int i, int j) {
		return sumNums[j+1]-sumNums[i];
	}
}
