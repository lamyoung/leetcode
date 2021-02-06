public class N1319MakeConnected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] cur : connections) {
            unionFind.union(cur[0], cur[1]);
        }
        return unionFind.getNum() - 1;
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

        public int getNum() {
            return num;
        }

        public int findParent(int idx) {
//            if (idx != parent[idx]) {
//                parent[idx] = findParent(parent[idx]);
//            }
//            return parent[idx];
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
                num--;
                return true;
            }
            return false;
        }
    }
}
