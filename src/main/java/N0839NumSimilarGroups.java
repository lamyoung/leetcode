public class N0839NumSimilarGroups {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = unionFind.findParent(i), fj = unionFind.findParent(j);
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    unionFind.union(fi, fj);
                }
            }
        }
        return unionFind.num;
    }

    public boolean check(String a, String b, int len) {
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {
                    return false;
                }
            }
        }
        return true;
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
                num--;
                return true;
            }
            return false;
        }
    }
}
