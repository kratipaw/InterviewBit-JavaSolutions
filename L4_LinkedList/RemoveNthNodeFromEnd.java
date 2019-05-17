public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(2);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = new LinkedListNode(5);
		
		list.printLinkedList();
		/*LinkedListNode result = removeNthFromEnd(list.root, 2);
		
		printLinkedList(result);
		*/
		System.out.println("Efficient : ");
		
		LinkedListNode res = removeNthNodeFromEnd_Effecient(list.root, 6);
		printLinkedList(res);

	}
	
private static void printLinkedList(LinkedListNode node) {
    	
    	LinkedListNode element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
	
	private static LinkedListNode removeNthFromEnd(LinkedListNode head, int B) {
		
		int len = length(head);
		
		if(B>len)
			return head;
		else if (B == len) {
			head = head.next;
			return head;
		}
		int fromStart = len - B + 1;
		
		int count = 0;
		LinkedListNode element = head;
		LinkedListNode prev = null;
		while(element!=null) {
			
			count++;
			
			if(count == fromStart) 
				break;
			
			prev = element;
			element = element.next;
		}
		
		prev.next = element.next;
		
		return head;
		
	}
	
	private static int length(LinkedListNode head) {
		
		LinkedListNode element = head;
		
		int length = 0;
		
		while(element!=null) {
			
			length++;
			
			element = element.next;
		}
		
		return length;
	}
	
	private static LinkedListNode removeNthNodeFromEnd_Effecient(LinkedListNode A, int B) {
		
		LinkedListNode first = A;
		LinkedListNode second = A;
		
		int count = 0;
		
		while(count<=B-1) {
			
			if(first == null) {
				A = A.next;
				return A;
			}
			
			first = first.next;
			count++;
		}

		LinkedListNode prev = null;
		while(first!=null) {
			prev = second;
			first = first.next;
			second = second.next;
		}

		if(prev!=null)
			prev.next = second.next;
		else
			A = A.next;
		return A;
	}

}
