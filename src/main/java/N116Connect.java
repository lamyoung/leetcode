import java.util.LinkedList;
import java.util.Queue;

public class N116Connect {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        int curCount = 1;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            curCount--;
            if(curNode.left != null) {
                queue.add(curNode.left);
                queue.add(curNode.right);
            }
            count += 2;
            while (curCount > 0) {
                curNode.next = queue.poll();
                curNode = curNode.next;
                if(curNode.left != null) {
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                }
                count += 2;
                curCount--;
            }
            curCount = count;
            count = 0;
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;
}
