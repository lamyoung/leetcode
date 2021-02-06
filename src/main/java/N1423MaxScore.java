public class N1423MaxScore {

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int max = sum;
        int n = cardPoints.length;
        for (int i = k - 1; i >= 0; i--) {
            sum = sum - cardPoints[i] + cardPoints[n - k + i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
