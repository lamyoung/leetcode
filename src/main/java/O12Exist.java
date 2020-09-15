import org.omg.CORBA.INTERNAL;

import javax.security.auth.callback.TextInputCallback;
import java.util.HashMap;
import java.util.HashSet;

public class O12Exist {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exist(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || k > word.length() - 1 || word.charAt(k) != board[i][j]) {
            return false;
        }
        k++;
        if (k >= word.length()) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = exist(board, i - 1, j, word, k) || exist(board, i + 1, j, word, k) || exist(board, i, j - 1, word, k) || exist(board, i, j + 1, word, k);
        board[i][j] = tmp;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(board, word));
    }
}
