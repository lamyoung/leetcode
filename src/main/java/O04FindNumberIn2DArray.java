public class O04FindNumberIn2DArray {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0, j = matrix[0].length-1; i < matrix.length && j >= 0; ) {
            if (target == matrix[i][j]) {
                return true;
            }
            if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}, {5}};
        System.out.println(findNumberIn2DArray(matrix, 6));
    }
}
