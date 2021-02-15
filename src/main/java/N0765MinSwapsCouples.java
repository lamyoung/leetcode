public class N0765MinSwapsCouples {

    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getNum();
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
            } else {
                max = Math.max(max, cur);
                cur = 0;
            }
        }
        return max;
    }
}

class UnionFind {
    int num;
    int[] parent;

    public UnionFind(int num) {
        this.num = num;
        parent = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int val) {
        while (val != parent[val]) {
            parent[val] = parent[parent[val]];
            val = parent[val];
        }
        return val;
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

    public int getNum() {
        return num;
    }
}