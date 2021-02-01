import java.util.Comparator;
import java.util.PriorityQueue;

public class N0023MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> tmp = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                ListNode node1 = (ListNode) o1;
                ListNode node2 = (ListNode) o2;
                return node1.val - node2.val;
            }
        });
        for(int i=0; i<lists.length; i++) {
            ListNode head = lists[i];
            while(head != null) {
                tmp.add(head);
                head = head.next;
            }
        }
        if(tmp.isEmpty()) {
            return null;
        }
        ListNode res = tmp.poll();
        ListNode head = res;
        while(!tmp.isEmpty()) {
            head.next = tmp.poll();
            head = head.next;
        }
        head.next = null;
        return res;
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
