package L4_LinkedList;

public class PartitionList {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(4);
		root.next.next = new Node(3);
		root.next.next.next = new Node(2);
		root.next.next.next.next = new Node(5);
		root.next.next.next.next.next = new Node(2);
		
		int B = 3;
		
		Node result = partition(root, B);
		
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
	
	private static Node partition(Node A, int B) {
    
		if(A == null || A.next == null)
			return A;
		
		Node beforeStart = null; 
		Node beforeEnd = null;
		
		Node afterStart = null;
		Node afterEnd = null;
		
		Node current = A;
		
		while(current != null) 
		{
			Node next = current.next;
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
