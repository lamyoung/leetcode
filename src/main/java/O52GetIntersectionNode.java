public class O52GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getListSize(headA);
        int lenB = getListSize(headB);
        if (lenA > lenB) {
            int differ = lenA - lenB;
            while (differ > 0) {
                headA = headA.next;
                differ--;
            }
        }
        if (lenA < lenB) {
            int differ = lenB - lenA;
            while (differ > 0) {
                headB = headB.next;
                differ--;
            }
        }
        while (headA != null) {
            if (headA.val == headB.val) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public int getListSize(ListNode root) {
        ListNode newRoot = root.next;
        int count = 1;
        while (newRoot != null) {
            count++;
            newRoot = newRoot.next;
        }
        return count;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
