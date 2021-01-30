public class N5607WaysToMakeFair {

    public int waysToMakeFair(int[] nums) {
        int[][] res = new int[nums.length][4];
        int suml1 = 0, suml2 = 0, sumr1 = 0, sumr2 = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i][0] = suml1;
            res[i][1] = suml2;
            if ((i & 1) == 1) {
                suml1 += nums[i];
            } else {
                suml2 += nums[i];
            }
        }
        for(int i=nums.length-1; i>=0; i--) {
            res[i][2] = sumr1;
            res[i][3] = sumr2;
            if ((i & 1) == 0) {
                sumr1 += nums[i];
            } else {
                sumr2 += nums[i];
            }
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if((res[i][0]+res[i][2]) == (res[i][1] + res[i][3])) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        N5607WaysToMakeFair n = new N5607WaysToMakeFair();
        int[] nums = new int[]{1,2,3};
        System.out.println(n.waysToMakeFair(nums));
    }
}
