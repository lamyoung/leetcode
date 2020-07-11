public class GetDecimalValue {

	public int getDecimalValue(ListNode head) {
		int res = 0;
		while (head != null) {
			res = 2 * res + head.val;
			head = head.next;
		}
		return res;
	}

	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
