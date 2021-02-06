public class N0959RegionsBySlashes {

    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4 * N * N;
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] strArr = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                int idx = 4 * (i * N + j);
                if (strArr[j] == '/') {
                    unionFind.union(idx, idx + 3);
                    unionFind.union(idx + 1, idx + 2);
                } else if (strArr[j] == '\\') {
                    unionFind.union(idx, idx + 1);
                    unionFind.union(idx + 2, idx + 3);
                } else {
                    unionFind.union(idx, idx + 1);
                    unionFind.union(idx + 1, idx + 2);
                    unionFind.union(idx + 2, idx + 3);
                }
                if (j + 1 < N) {
                    unionFind.union(idx + 1, 4 * (i * N + j + 1) + 3);
                }
                if (i + 1 < N) {
                    unionFind.union(idx + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return unionFind.getNum();
    }

    private static class UnionFind {
        private int num;
        private int[] parent;

        public UnionFind(int num) {
            this.num = num;
            parent = new int[num];
            for (int i = 0; i < num; i++) {
                parent[i] = i;
            }
        }

        public int getNum() {
            return num;
        }

        public int getParent(int n) {
            while (n != parent[n]) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }

        public void union(int x, int y) {
            int rootX = getParent(x);
            int rootY = getParent(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                num--;
            }
        }
    }
}
