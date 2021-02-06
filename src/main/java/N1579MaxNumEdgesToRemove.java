public class N1579MaxNumEdgesToRemove {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int remove = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int[] cur : edges) {
            if (cur[0] == 3 && !unionFind.union(cur[1] - 1, cur[2] - 1)) {
                remove++;
            }
        }
        UnionFind a = (UnionFind) unionFind.clone();
        UnionFind b = (UnionFind) unionFind.clone();
        for (int[] cur : edges) {
            if (cur[0] == 1 && !a.union(cur[1] - 1, cur[2] - 1)) {
                remove++;
            }
        }
        for (int[] cur : edges) {
            if (cur[0] == 2 && !b.union(cur[1] - 1, cur[2] - 1)) {
                remove++;
            }
        }
        if (a.size > 1 || b.size > 1) {
            return -1;
        }
        return remove;
    }

    private class UnionFind {
        int[] parent;
        int size;

        public UnionFind(int size) {
            this.size = size;
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int getSize() {
            return size;
        }

        public int getParent(int idx) {
            while (idx != parent[idx]) {
                parent[idx] = parent[parent[idx]];
                idx = parent[idx];
            }
            return idx;
        }

        public boolean union(int x, int y) {
            int rootX = getParent(x);
            int rootY = getParent(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size--;
                return true;
            }
            return false;
        }

        @Override
        protected Object clone() {
            UnionFind c = new UnionFind(size);
            c.parent = parent.clone();
            c.size = size;
            return c;
        }
    }
}
