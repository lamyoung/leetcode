public class J0204Partition {

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode small = new ListNode(0);
        ListNode big = new ListNode(0);
        ListNode curBig = big;
        ListNode curSmall = small;
        while (head != null) {
            if (head.val < x) {
                curSmall.next = head;
                curSmall = head;
            } else {
                curBig.next = head;
                curBig = head;
            }
            head = head.next;
        }
        curBig.next = null;
        curSmall.next = big.next;
        return small.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
