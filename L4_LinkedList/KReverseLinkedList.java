public class KReverseLinkedList {

	public static void main(String[] args) {

		LinkedListNode A = new LinkedListNode(1);
		A.next = new LinkedListNode(2);
		A.next.next = new LinkedListNode(3);
		A.next.next.next = new LinkedListNode(4);
		A.next.next.next.next = new LinkedListNode(5);
		A.next.next.next.next.next = new LinkedListNode(6);
		A.next.next.next.next.next.next = new LinkedListNode(7);
		A.next.next.next.next.next.next.next = new LinkedListNode(8);
		
		LinkedListNode result = reverseList(A, 3);
		
		printList(result);
		
	}

	private static void printList(LinkedListNode head) {
		
		LinkedListNode element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}
	
	private static LinkedListNode reverseList(LinkedListNode A, int B) {
		
		if(A == null)
			return A;
		
		LinkedListNode curr = A; 
        LinkedListNode next = null; 
        LinkedListNode prev = null; 
         
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
