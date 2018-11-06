package L4_LinkedList;

public class AddTwoNumAsList {

	public static void main(String[] args) {

		Node A = new Node(2);
		A.next = new Node(4);
		A.next.next = new Node(3);
		
		printLinkedList(A);
		
		Node B = new Node(5);
		B.next = new Node(5);
		B.next.next = new Node(4);
		
		printLinkedList(B);
		
		Node result = addTwoNumbers(A, B);
		
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
	
	private static Node addTwoNumbers(Node A, Node B) {
    
		Node first = A;
		Node second = B;
		
		Node result = null;
		
		Node temp = null;
		Node prev = null;
		
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
			
			temp = new Node(sum);
			
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
			temp.next = new Node(carry);
		
		return result;
	
	}
}
