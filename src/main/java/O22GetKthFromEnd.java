public class O22GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode originHead = head;
        for (int i = 0; i < k - 1; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            originHead = originHead.next;
        }
        return originHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
