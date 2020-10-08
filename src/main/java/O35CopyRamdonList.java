public class O35CopyRamdonList {

    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        Node tmp = head;
        while(head != null) {
            Node headNew = new Node(head.val);
            headNew.next = head.next;
            head.next = headNew;
            head = headNew.next;
        }
        head = tmp;
        while(head != null) {
            if(head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = tmp;
        Node res = head.next;
        while(head != null) {
            Node headNew = head.next;
            head.next = headNew.next;
            if (head.next != null) {
                headNew.next = head.next.next;
            }
            head = head.next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
