import java.util.ArrayList;
import java.util.List;

public class ShiftGrid {

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int row = grid.length;
		int col = grid[0].length;
		int length = row * col;
		List<List<Integer>> res = new ArrayList<>(row);
		for (int i = 0; i < row; i++) {
			List<Integer> tmp = new ArrayList<>(col);
			for (int j = 0; j < col; j++) {
				int tmpPos = (length + row * i + j + 1 - k % length) % length;
				int tmpRow = tmpPos / row;
				int tmpCol;
				if(tmpPos%row==0) {
					tmpCol = col-1;
					tmpRow--;
					if(tmpRow<0) {
						tmpRow = row-1;
					}
				} else {
					tmpCol = tmpPos-tmpRow*row-1;
				}
				tmp.add(grid[tmpRow][tmpCol]);
			}
			res.add(tmp);
		}
		return res;
	}
}
