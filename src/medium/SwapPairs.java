package medium;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null)
			return head;
		
		ListNode first = head;
		ListNode second = head.next;
		
		while(true) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;
			
			first = second.next;
			if(first==null)
				break;
			second = first.next;
			if(second==null)
				break;

		}
		
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
