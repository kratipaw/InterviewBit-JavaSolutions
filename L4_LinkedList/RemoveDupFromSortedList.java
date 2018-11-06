package L4_LinkedList;

public class RemoveDupFromSortedList {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.root = new Node(1);
		list.root.next = new Node(1);
		list.root.next.next = new Node(2);
		list.root.next.next.next = new Node(2);
		list.root.next.next.next.next = new Node(3);
		list.root.next.next.next.next.next = new Node(3);
		list.root.next.next.next.next.next.next = new Node(3);
		list.root.next.next.next.next.next.next.next = new Node(4);
		list.root.next.next.next.next.next.next.next.next = new Node(4);
		//list.root.next.next.next.next.next.next.next.next.next = new Node(5);
		
		list.printLinkedList();
		
		/*Node result = deleteDuplicates(list.root);
		
		printLinkedList(result);
		*/

		Node result = deleteDuplicates_2(list.root);
		
		printLinkedList(result);
		
	}
	
	private static void printLinkedList(Node node) {
    	
    	Node element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
	
	private static Node deleteDuplicates(Node A) {
		
		Node prev = null;
		
		Node curr = A;
		
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
	
	private static Node deleteDuplicates_2(Node A) {
		
		Node dummy = new Node(0);
		dummy.next = A;
		Node prev = dummy;
		Node curr = A;
		
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
