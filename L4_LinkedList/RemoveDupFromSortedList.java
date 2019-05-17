public class RemoveDupFromSortedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(1);
		list.root.next.next = new LinkedListNode(2);
		list.root.next.next.next = new LinkedListNode(2);
		list.root.next.next.next.next = new LinkedListNode(3);
		list.root.next.next.next.next.next = new LinkedListNode(3);
		list.root.next.next.next.next.next.next = new LinkedListNode(3);
		list.root.next.next.next.next.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next.next.next.next.next = new LinkedListNode(4);
		//list.root.next.next.next.next.next.next.next.next.next = new LinkedListNode(5);
		
		list.printLinkedList();
		
		/*LinkedListNode result = deleteDuplicates(list.root);
		
		printLinkedList(result);
		*/

		LinkedListNode result = deleteDuplicates_2(list.root);
		
		printLinkedList(result);
		
	}
	
	private static void printLinkedList(LinkedListNode node) {
    	
    	LinkedListNode element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
	
	private static LinkedListNode deleteDuplicates(LinkedListNode A) {
		
		LinkedListNode prev = null;
		
		LinkedListNode curr = A;
		
		while(curr!=null) {
			
			if(prev != null && prev.data == curr.data) {
				prev.next = curr.next;
			}
			else {
				prev = curr;
			}
			curr = curr.next;
		}
		
		return A;
	}
	
	private static LinkedListNode deleteDuplicates_2(LinkedListNode A) {
		
		LinkedListNode dummy = new LinkedListNode(0);
		dummy.next = A;
		LinkedListNode prev = dummy;
		LinkedListNode curr = A;
		
		while(curr!=null) {
			
			while(curr.next!=null && prev!=null && prev.next.data == curr.next.data) {
				curr = curr.next;
			}
			
			if(prev !=null && prev.next == curr)
				prev = prev.next;
			else if(prev!=null && prev.next!=curr)
				prev.next = curr.next;
			else
				prev = curr;
			
			curr = curr.next;
		}
		return dummy.next;
	}

}
