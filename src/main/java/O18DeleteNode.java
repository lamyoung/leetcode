public class O18DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode tmp = head;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            if (head.val != val) {
                pre = head;
                head = head.next;
            } else {
                pre.next = head.next;
                break;
            }
        }
        return tmp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
