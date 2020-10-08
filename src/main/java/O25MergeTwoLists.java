public class O25MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode mark = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                res.next = l2;
                break;
            }
            if (l2 == null) {
                res.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                res.next = l1;
                res = l1;
                l1 = l1.next;
            } else {
                res.next = l2;
                res = l2;
                l2 = l2.next;
            }
        }
        return mark.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
