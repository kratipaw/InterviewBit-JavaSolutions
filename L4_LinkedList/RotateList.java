public class RotateList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(2);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = new LinkedListNode(5);
		//list.root.next.next.next.next.next = new LinkedListNode(3);
		/*list.root.next.next.next.next.next.next = new LinkedListNode(3);
		list.root.next.next.next.next.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next.next.next.next.next = new LinkedListNode(4);*/
		//list.root.next.next.next.next.next.next.next.next.next = new LinkedListNode(5);
		
		list.printLinkedList();
		
		LinkedListNode result = rotateNode(list.root, 2);
		
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

	private static LinkedListNode rotateNode(LinkedListNode A, int B) {
		
		if(B == 0)
			return A;
		
		LinkedListNode curr = A;
		
		int count = 1;
		
		while(curr.next!=null) {
			curr = curr.next;
			count++;
		}
		
		curr.next = A;
		
		int preLen = count - B%count-1;
		
		LinkedListNode prev = A;
		
		while(preLen>0) {
			prev = prev.next;
			preLen--;
		}
		
		A = prev.next;
		prev.next = null;
		
		return A;
	}
}
