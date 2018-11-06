package L4_LinkedList;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new Node(1);
		list.root.next = new Node(2);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = new Node(5);
		
		list.printLinkedList();
		/*Node result = removeNthFromEnd(list.root, 2);
		
		printLinkedList(result);
		*/
		System.out.println("Efficient : ");
		
		Node res = removeNthNodeFromEnd_Effecient(list.root, 6);
		printLinkedList(res);

	}
	
private static void printLinkedList(Node node) {
    	
    	Node element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
	
	private static Node removeNthFromEnd(Node head, int B) {
		
		int len = length(head);
		
		if(B>len)
			return head;
		else if (B == len) {
			head = head.next;
			return head;
		}
		int fromStart = len - B + 1;
		
		int count = 0;
		Node element = head;
		Node prev = null;
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
	
	private static int length(Node head) {
		
		Node element = head;
		
		int length = 0;
		
		while(element!=null) {
			
			length++;
			
			element = element.next;
		}
		
		return length;
	}
	
	private static Node removeNthNodeFromEnd_Effecient(Node A, int B) {
		
		Node first = A;
		Node second = A;
		
		int count = 0;
		
		while(count<=B-1) {
			
			if(first == null) {
				A = A.next;
				return A;
			}
			
			first = first.next;
			count++;
		}

		Node prev = null;
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
