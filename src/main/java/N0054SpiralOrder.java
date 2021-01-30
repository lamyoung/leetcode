import java.util.ArrayList;
import java.util.List;

public class N0054SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowUp = 0, rowDown = matrix.length - 1, colLft = 0, colRgt = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (rowUp < rowDown && colLft < colRgt) {
            for (int i = colLft; i < colRgt; i++) {
                res.add(matrix[rowUp][i]);
            }
            for (int i = rowUp; i < rowDown; i++) {
                res.add(matrix[i][colRgt]);
            }
            for (int i = colRgt; i > colLft; i--) {
                res.add(matrix[rowDown][i]);
            }
            for (int i = rowDown; i > rowUp; i--) {
                res.add(matrix[i][colLft]);
            }
            rowUp++;
            rowDown--;
            colLft++;
            colRgt--;
        }
        if (rowUp < rowDown && colLft==colRgt) {
            for (int i = rowUp; i <= rowDown; i++) {
                res.add(matrix[i][colLft]);
            }
        }
        if (rowUp == rowDown && colLft < colRgt) {
            for (int i = colLft; i <= colRgt; i++) {
                res.add(matrix[rowUp][i]);
            }
        }
        if(colLft==colRgt && rowUp==rowDown) {
            res.add(matrix[rowUp][colLft]);
        }
        return res;
    }
}
