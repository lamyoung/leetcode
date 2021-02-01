public class N5613MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int tmpMax = 0;
        for (int i = 0; i < accounts.length; i++) {
            tmpMax = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                tmpMax += accounts[i][j];
            }
            max = Math.max(max, tmpMax);
        }
        return max;
    }
}
