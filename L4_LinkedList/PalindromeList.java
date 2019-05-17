public class PalindromeList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(1);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next.next.next = new LinkedListNode(3);
		list.root.next.next.next.next.next.next.next = new LinkedListNode(1);
		list.root.next.next.next.next.next.next.next.next = new LinkedListNode(1);
		
		System.out.println(lPalin(list.root));
	}

	private static int lPalin(LinkedListNode A) {
    
		LinkedListNode slow = A;
		LinkedListNode fast = A;
		LinkedListNode prev_slow = null;
		
		if(A!=null && A.next!=null) {
		
			while(slow != null && fast != null && fast.next != null) {
				
				prev_slow = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			
			//LinkedListNode midNode = null;
			
			if(fast!=null) {
				//midNode = slow;
				slow = slow.next;
			}
			
			prev_slow.next = null;
			
			LinkedListNode second = reverse(slow);
			LinkedListNode first = A;
			while(second!=null) {
				
				if(first.data!=second.data)
					return 0;
				
				first = first.next;
				second = second.next;
			}
		}
		return 1;
	}
	
	private static LinkedListNode reverse(LinkedListNode node) {
		
		LinkedListNode curr = node;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		
		while(curr!=null) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		return prev;
	}
}
