public class N0376WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null) {
            return 0;
        }
        if(nums.length == 0) {
            return 0;
        }
        int[] resIncr = new int[nums.length];
        resIncr[0] = 1;
        int[] resDcr = new int[nums.length];
        resDcr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int tmpIncr = 1;
            int tmpDcr = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    tmpIncr = Math.max(tmpIncr, resDcr[j] + 1);
                }
                if (nums[i] < nums[j]) {
                    tmpDcr = Math.max(tmpDcr, resIncr[j] + 1);
                }
                tmpIncr = Math.max(tmpIncr, resIncr[j]);
                tmpDcr = Math.max(tmpDcr, resDcr[j]);
            }
            resIncr[i] = tmpIncr;
            resDcr[i] = tmpDcr;
        }
        int re = 0;
        for (int i = 0; i < nums.length; i++) {
            re = Math.max(re, resIncr[i]);
            re = Math.max(re, resDcr[i]);
        }
        return re;
    }

    public static void main(String[] args) {
        N0376WiggleMaxLength w = new N0376WiggleMaxLength();
        int[] nums = new int[]{1,7,4,9,2,5};
        System.out.println(w.wiggleMaxLength(nums));
    }
}
