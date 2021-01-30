import javafx.util.Pair;

import java.util.HashSet;

public class N0079Exist {

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(visited, board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int[][] visited, char[][] board, String word, int num, int i, int j) {
        if (board[i][j] == word.charAt(num)) {
            if (num == word.length() - 1) {
                return true;
            }
            visited[i][j] = 1;
            if (i > 0 && visited[i - 1][j] == 0) {
                if (dfs(visited, board, word, num + 1, i - 1, j)) {
                    return true;
                }
            }
            if (i < board.length - 1 && visited[i + 1][j] == 0) {
                if (dfs(visited, board, word, num + 1, i + 1, j)) {
                    return true;
                }
            }
            if (j > 0 && visited[i][j - 1] == 0) {
                if (dfs(visited, board, word, num + 1, i, j - 1)) {
                    return true;
                }
            }
            if (j < board[i].length - 1 && visited[i][j + 1] == 0) {
                if (dfs(visited, board, word, num + 1, i, j + 1)) {
                    return true;
                }
            }
            visited[i][j] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        N0079Exist e = new N0079Exist();
        char[][] res = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(e.exist(res, "ABCB"));
    }
}
