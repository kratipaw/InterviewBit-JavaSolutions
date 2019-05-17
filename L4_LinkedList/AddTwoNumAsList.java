public class AddTwoNumAsList {

	public static void main(String[] args) {

		LinkedListNode A = new LinkedListNode(2);
		A.next = new LinkedListNode(4);
		A.next.next = new LinkedListNode(3);
		
		printLinkedList(A);
		
		LinkedListNode B = new LinkedListNode(5);
		B.next = new LinkedListNode(5);
		B.next.next = new LinkedListNode(4);
		
		printLinkedList(B);
		
		LinkedListNode result = addTwoNumbers(A, B);
		
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
	
	private static LinkedListNode addTwoNumbers(LinkedListNode A, LinkedListNode B) {
    
		LinkedListNode first = A;
		LinkedListNode second = B;
		
		LinkedListNode result = null;
		
		LinkedListNode temp = null;
		LinkedListNode prev = null;
		
		int carry = 0, sum = 0;
		
		while(first!=null || second!=null) {
			
			int data1 = 0;
			if(first!=null)
				data1 = first.data;
			
			int data2 = 0;
			if(second!=null)
				data2 = second.data;
			
			sum = data1 + data2 + carry;
			
			if(sum>=10)
				carry = 1;
			else
				carry = 0;
			
			sum = sum % 10;
			
			temp = new LinkedListNode(sum);
			
			if(result == null)
				result = temp;
			else
				prev.next = temp;
			
			prev = temp;
			
			if(first!=null)
				first = first.next;
			
			if(second!=null)
				second = second.next;
		}
		
		if(carry>0)
			temp.next = new LinkedListNode(carry);
		
		return result;
	
	}
}
