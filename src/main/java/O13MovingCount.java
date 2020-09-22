import java.util.LinkedList;
import java.util.Queue;

public class O13MovingCount {

    // 用队列和栈，模拟递归，可以解决递归问题
    public static int movingCount(int m, int n, int k) {
        int[][] matrix = new int[m][n];
        int[] res = new int[1];
        dfs(matrix, 0, 0, k, res);
        return res[0];
    }

    public static boolean dfs(int[][] matrix, int m, int n, int k, int[] res) {
        if (m < 0 || n < 0 || m > matrix.length - 1 || n > matrix[0].length - 1 || matrix[m][n] == -1 || matrix[m][n] == 1) {
            return false;
        }
        if (getSum(m, n) > k) {
            matrix[m][n] = -1;
            return false;
        }
        matrix[m][n] = 1;
        res[0] = res[0] + 1;
        return dfs(matrix, m + 1, n, k, res) || dfs(matrix, m, n + 1, k, res);
    }

    public static int getSum(int m, int n) {
        int sum = 0;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] matrix = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int count = 0;
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            if (matrix[tmp[0]][tmp[1]] == -1 || matrix[tmp[0]][tmp[1]] == 1) {
                continue;
            }
            if (getSum(tmp[0], tmp[1]) > k) {
                matrix[tmp[0]][tmp[1]] = -1;
                continue;
            }
            matrix[tmp[0]][tmp[1]] = 1;
            count++;
            if (tmp[0] < matrix.length - 1) {
                queue.add(new int[]{tmp[0] + 1, tmp[1]});
            }
            if(tmp[1] < matrix[0].length - 1) {
                queue.add(new int[]{tmp[0], tmp[1] + 1});
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(movingCount2(2, 3, 2));
    }
}
