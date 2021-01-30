public class N064MinPathSum {

    public int minPathSum(int[][] grid) {
        int[] res = new int[grid[0].length];
        res[0] = grid[0][0];
        for (int col = 1; col < grid[0].length; col++) {
            res[col] = res[col - 1] + grid[0][col];
        }
        for (int row = 1; row < grid.length; row++) {
            res[0] += grid[row][0];
            for (int col = 1; col < grid[row].length; col++) {
                res[col] = grid[row][col] + Math.min(res[col - 1], res[col]);
            }
        }
        return res[grid[0].length - 1];
    }
}
