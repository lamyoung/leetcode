public class N0086Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode res = less;
        ListNode next = more;
        while(head != null) {
            ListNode cur = head;
            if(head.val<x) {
                less.next = cur;
                less = cur;
            } else {
                more.next = cur;
                more = cur;
            }
            head = head.next;
            cur.next = null;
        }
        less.next = next.next;
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
