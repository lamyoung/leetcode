public class J0107Rotate {

    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int num = matrix.length;
        for (int i = 0; i < num / 2; i++) {
            for (int j = i; j < num - i; j++) {
                matrix[i][j] += matrix[num - 1 - j][i];
                matrix[num - 1 - j][i] = matrix[i][j] - matrix[num - 1 - j][i];
                matrix[i][j] = matrix[i][j] - matrix[num - 1 - j][i];

                matrix[num - 1 - j][i] += matrix[num - 1 - i][num - 1 - j];
                matrix[num - 1 - i][num - 1 - j] = matrix[num - 1 - j][i] - matrix[num - 1 - i][num - 1 - j];
                matrix[num - 1 - j][i] = matrix[num - 1 - j][i] - matrix[num - 1 - i][num - 1 - j];

                matrix[num - 1 - i][num - 1 - j] += matrix[j][num - 1 - i];
                matrix[j][num - 1 - i] = matrix[num - 1 - i][num - 1 - j] - matrix[j][num - 1 - i];
                matrix[num - 1 - i][num - 1 - j] = matrix[num - 1 - i][num - 1 - j] - matrix[j][num - 1 - i];

                matrix[j][num - 1 - i] += matrix[i][j];
                matrix[i][j] = matrix[j][num - 1 - i] - matrix[i][j];
                matrix[j][num - 1 - i] = matrix[j][num - 1 - i] - matrix[i][j];
            }
        }
    }
}
