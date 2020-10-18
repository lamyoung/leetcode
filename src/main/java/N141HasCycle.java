public class N141HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head.next;
        while (slow != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            if (slow.next == null) {
                return false;
            }
            slow = slow.next.next;

        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
