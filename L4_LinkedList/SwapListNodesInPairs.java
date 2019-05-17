public class SwapListNodesInPairs {

	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(10);
		list.root.next = new LinkedListNode(5);
		list.root.next.next = new LinkedListNode(4);
		list.root.next.next.next = new LinkedListNode(3);
		
		System.out.println("original list : ");
		
		printList(list.root);
		
		LinkedListNode head = swapPairs(list.root);
		
		printList(head);
		
	}
	
	private static void printList(LinkedListNode head) {
		
		LinkedListNode element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}

	private static LinkedListNode swapPairs(LinkedListNode A) {
		
		if(A == null || A.next == null)
			return A;
		
		LinkedListNode prev = A;
		
		LinkedListNode curr = A.next;
		
		LinkedListNode next = null;
		
		LinkedListNode head = curr;
		
		while(true) {
			
			next = curr.next;
			
			curr.next = prev;
			
			if(next == null || next.next == null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			
			prev = next;
			
			curr = next.next;
		}
	
		return head;
    }
}
