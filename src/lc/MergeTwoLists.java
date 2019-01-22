package lc;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode l = null;

		if (l1.val <= l2.val) {
			l = l1;
			l1 = l1.next;
		} else {
			l = l2;
			l2 = l2.next;
		}
		ListNode head = l;
		
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				l.next = l1;
				l1 = l1.next;
			} else {
				l.next = l2;
				l2 = l2.next;
			}
			l = l.next;
		} 

		if (l1 == null)
			l.next = l2;
		else
			l.next = l1;

		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
