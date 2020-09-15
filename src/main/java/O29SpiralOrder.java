public class O29SpiralOrder {

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int count = 0;
        for (; left < right && top < bottom; left += 1, right -= 1, top += 1, bottom -= 1) {
            for (int i = left; i < right; i++) {
                res[count] = matrix[top][i];
                count++;
            }
            for (int i = top; i < bottom; i++) {
                res[count] = matrix[i][right];
                count++;
            }
            for (int i = right; i > left; i--) {
                res[count] = matrix[bottom][i];
                count++;
            }
            for (int i = bottom; i > top; i--) {
                res[count] = matrix[i][left];
                count++;
            }
        }
        if (left == right) {
            for (int i = top; i <= bottom; i++) {
                res[count] = matrix[i][left];
                count++;
            }
            return res;
        }
        if (top == bottom) {
            for (int i = left; i <= right; i++) {
                res[count] = matrix[top][i];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3}, {2}};
        int[] res = spiralOrder(matrix);
    }
}