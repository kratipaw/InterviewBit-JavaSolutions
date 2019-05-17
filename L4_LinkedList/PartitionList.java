public class PartitionList {

	public static void main(String[] args) {
		LinkedListNode root = new LinkedListNode(1);
		root.next = new LinkedListNode(4);
		root.next.next = new LinkedListNode(3);
		root.next.next.next = new LinkedListNode(2);
		root.next.next.next.next = new LinkedListNode(5);
		root.next.next.next.next.next = new LinkedListNode(2);
		
		int B = 3;
		
		LinkedListNode result = partition(root, B);
		
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
	
	private static LinkedListNode partition(LinkedListNode A, int B) {
    
		if(A == null || A.next == null)
			return A;
		
		LinkedListNode beforeStart = null; 
		LinkedListNode beforeEnd = null;
		
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		LinkedListNode current = A;
		
		while(current != null) 
		{
			LinkedListNode next = current.next;
			current.next = null;
			if(current.data < B) 
			{
				if(beforeStart == null) 
				{
					beforeStart = current;
					beforeEnd = beforeStart;
				}
				else
				{
					beforeEnd.next = current;
					beforeEnd = current;
				}
			}
			else
			{
				if(afterStart == null) 
				{
					afterStart = current;
					afterEnd = afterStart;
				}
				else
				{
					afterEnd.next = current;
					afterEnd = current;
				}
			}
			
			current = next;
		}
		
		if(beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		
		return beforeStart;
	
	}

}
