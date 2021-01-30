public class N062UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            res[0][i] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                res[row][col] = res[row - 1][col] + res[row][col - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}
