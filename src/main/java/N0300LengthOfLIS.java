public class N0300LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        res[0]=1;
        for(int i=1; i<nums.length; i++) {
            int tmpRes = 1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]) {
                    tmpRes = Math.max(tmpRes, res[j]+1);
                }
            }
            res[i] = tmpRes;
        }
        int re = 0;
        for(int i=0; i<res.length; i++) {
            re = Math.max(re, res[i]);
        }
        return re;
    }

    public static void main(String[] args) {
        N0300LengthOfLIS l = new N0300LengthOfLIS();
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS(nums));
    }
}
