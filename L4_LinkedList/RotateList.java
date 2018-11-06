package L4_LinkedList;

public class RotateList {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new Node(1);
		list.root.next = new Node(2);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = new Node(5);
		//list.root.next.next.next.next.next = new Node(3);
		/*list.root.next.next.next.next.next.next = new Node(3);
		list.root.next.next.next.next.next.next.next = new Node(4);
		list.root.next.next.next.next.next.next.next.next = new Node(4);*/
		//list.root.next.next.next.next.next.next.next.next.next = new Node(5);
		
		list.printLinkedList();
		
		Node result = rotateNode(list.root, 2);
		
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

	private static Node rotateNode(Node A, int B) {
		
		if(B == 0)
			return A;
		
		Node curr = A;
		
		int count = 1;
		
		while(curr.next!=null) {
			curr = curr.next;
			count++;
		}
		
		curr.next = A;
		
		int preLen = count - B%count-1;
		
		Node prev = A;
		
		while(preLen>0) {
			prev = prev.next;
			preLen--;
		}
		
		A = prev.next;
		prev.next = null;
		
		return A;
	}
}
