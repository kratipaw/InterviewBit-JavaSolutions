package L4_LinkedList;

public class InsertionSortList {

	public static void main(String[] args) {
		
		Node head = new Node(4);
		head.next = new Node(3);
		head.next.next = new Node(0);
		head.next.next.next = new Node(2);
		
		Node result = insertionSortList(head);
		
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
	
	
	private static Node insertionSortList(Node A){
		
		if (A == null || A.next == null) {
            return A;
        }
		
        Node dummy = new Node(0);
        
        Node curr = A;
        
        while (curr != null) {
            
        	Node temp = curr.next;
        	
        	Node node = dummy;
            
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
