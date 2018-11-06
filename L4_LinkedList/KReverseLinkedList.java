package L4_LinkedList;

public class KReverseLinkedList {

	public static void main(String[] args) {

		Node A = new Node(1);
		A.next = new Node(2);
		A.next.next = new Node(3);
		A.next.next.next = new Node(4);
		A.next.next.next.next = new Node(5);
		A.next.next.next.next.next = new Node(6);
		A.next.next.next.next.next.next = new Node(7);
		A.next.next.next.next.next.next.next = new Node(8);
		
		Node result = reverseList(A, 3);
		
		printList(result);
		
	}

	private static void printList(Node head) {
		
		Node element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}
	
	private static Node reverseList(Node A, int B) {
		
		if(A == null)
			return A;
		
		Node curr = A; 
        Node next = null; 
        Node prev = null; 
         
        int count = 0; 
  
        while (count < B && curr != null)  
        { 
		   next = curr.next; 
		   curr.next = prev; 
		   prev = curr; 
		   curr = next; 
		   count++; 
        } 
  
        if (next != null)  
        	A.next = reverseList(next, B); 
  
        return prev;
    }
}
