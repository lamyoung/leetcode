public class N063UhiquePathsWithObstacles {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[] res = new int[colLen];
        for (int i = 0; i < colLen; i++) {
            if (obstacleGrid[0][i] == 0) {
                res[i] = 1;
            } else {
                break;
            }
        }
        for (int row = 1; row < rowLen; row++) {
            if (obstacleGrid[row][0] == 1) {
                res[0] = 0;
            }
            for (int col = 1; col < colLen; col++) {
                if (obstacleGrid[row][col] == 0) {
                    res[col] += res[col - 1];
                } else {
                    res[col] = 0;
                }
            }
        }
        return res[colLen - 1];
    }
}
