public class N0778SwimInWater {

    public int swimInWater(int[][] grid) {
        int N = grid.length;
        int[][] height = new int[N * N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                height[grid[i][j]] = new int[]{i, j};
            }
        }
        UnionFind unionFind = new UnionFind(N * N);
        for (int i = 0; i < N * N; i++) {
            int[] cur = height[i];
            if (cur[0] > 0 && grid[cur[0] - 1][cur[1]] <= i) {
                unionFind.union(N * (cur[0] - 1) + cur[1], N * cur[0] + cur[1]);
            }
            if (unionFind.isConnected(0, N * N - 1)) {
                return i;
            }
            if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] <= i) {
                unionFind.union(N * cur[0] + cur[1] - 1, N * cur[0] + cur[1]);
            }
            if (unionFind.isConnected(0, N * N - 1)) {
                return i;
            }
            if (cur[0] < N - 1 && grid[cur[0] + 1][cur[1]] <= i) {
                unionFind.union(N * (cur[0] + 1) + cur[1], N * cur[0] + cur[1]);
            }
            if (unionFind.isConnected(0, N * N - 1)) {
                return i;
            }
            if (cur[1] < N - 1 && grid[cur[0]][cur[1] + 1] <= i) {
                unionFind.union(N * cur[0] + cur[1] + 1, N * cur[0] + cur[1]);
            }
            if (unionFind.isConnected(0, N * N - 1)) {
                return i;
            }
        }
        return 0;
    }

    private class UnionFind {
        int num;
        int[] parent;

        public UnionFind(int num) {
            this.num = num;
            parent = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int idx) {
            while (idx != parent[idx]) {
                parent[idx] = parent[parent[idx]];
                idx = parent[idx];
            }
            return idx;
        }

        public boolean union(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            }
            return false;
        }

        public boolean isConnected(int x, int y) {
            int rootX = findParent(x);
            int rootY = findParent(y);
            if (rootX != rootY) {
                return false;
            }
            return true;
        }
    }
}
