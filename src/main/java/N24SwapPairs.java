public class N24SwapPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode curPre = pre;
        while (head != null) {
            if (head.next == null) {
                curPre.next = head;
                break;
            } else {
                ListNode tmp = head.next.next;
                curPre.next = head.next;
                curPre.next.next = head;
                head.next = tmp;
                curPre = curPre.next.next;
                head = tmp;
            }
        }
        return pre.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
