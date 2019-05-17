public class InsertionSortList {

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode(4);
		head.next = new LinkedListNode(3);
		head.next.next = new LinkedListNode(0);
		head.next.next.next = new LinkedListNode(2);
		
		LinkedListNode result = insertionSortList(head);
		
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
	
	
	private static LinkedListNode insertionSortList(LinkedListNode A){
		
		if (A == null || A.next == null) {
            return A;
        }
		
        LinkedListNode dummy = new LinkedListNode(0);
        
        LinkedListNode curr = A;
        
        while (curr != null) {
            
        	LinkedListNode temp = curr.next;
        	
        	LinkedListNode node = dummy;
            
            while (node.next != null && node.next.data < curr.data) {
            	System.out.println("inside during node : " + node.data);
            	System.out.println("inside during node : " + node.next.data);
                node = node.next;
            }
            
            curr.next = node.next;
            
            node.next = curr;
            
            curr = temp;
        }
        return dummy.next;
	}

}
