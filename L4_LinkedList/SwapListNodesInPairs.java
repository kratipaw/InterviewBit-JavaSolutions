package L4_LinkedList;

public class SwapListNodesInPairs {

	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		
		list.root = new Node(10);
		list.root.next = new Node(5);
		list.root.next.next = new Node(4);
		list.root.next.next.next = new Node(3);
		
		System.out.println("original list : ");
		
		printList(list.root);
		
		Node head = swapPairs(list.root);
		
		printList(head);
		
	}
	
	private static void printList(Node head) {
		
		Node element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}

	private static Node swapPairs(Node A) {
		
		if(A == null || A.next == null)
			return A;
		
		Node prev = A;
		
		Node curr = A.next;
		
		Node next = null;
		
		Node head = curr;
		
		while(true) {
			
			next = curr.next;
			
			curr.next = prev;
			
			if(next == null || next.next == null) {
				prev.next = next;
				break;
			}
			prev.next = next.next;
			
			prev = next;
			
			curr = next.next;
		}
	
		return head;
    }
}
