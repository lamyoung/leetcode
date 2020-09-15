/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class O06ReversePrint {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        int count = 0;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            count++;
        }
        int[] res = new int[count];
        head = pre;
        for(int i=0; i<count; i++) {
            res[i] = head.val;
            head = head.next;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
