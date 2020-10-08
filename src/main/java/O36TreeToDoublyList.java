public class O36TreeToDoublyList {

    Node res = new Node(Integer.MAX_VALUE, null ,null);
    Node last = new Node(Integer.MIN_VALUE, null, null);

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        last.right = res;
        res.left = last;
        return res;
    }

    public Node[] dfs(Node root) {
        if(root.val<res.val) {
            res = root;
        }
        if(root.val>last.val) {
            last = root;
        }
        Node[] res1 = dfs(root.left);
        Node[] res2 = dfs(root.right);
        if(res1 == null) {
            if(res2==null) {
                return new Node[]{root, root};
            } else {
                root.right = res2[0];
                res2[0].left = root;
                return new Node[]{root, res2[1]};
            }
        } else {
            res1[1].right = root;
            root.left = res1[1];
            if(res2==null) {
                return new Node[]{res1[0], root};
            } else {
                root.right = res2[0];
                res2[0].left = root;
                return new Node[]{res1[0], res2[1]};
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
