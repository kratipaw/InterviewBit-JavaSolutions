package L4_LinkedList;

public class PalindromeList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.root = new Node(1);
		list.root.next = new Node(1);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = new Node(4);
		list.root.next.next.next.next.next = new Node(4);
		list.root.next.next.next.next.next.next = new Node(3);
		list.root.next.next.next.next.next.next.next = new Node(1);
		list.root.next.next.next.next.next.next.next.next = new Node(1);
		
		System.out.println(lPalin(list.root));
	}

	private static int lPalin(Node A) {
    
		Node slow = A;
		Node fast = A;
		Node prev_slow = null;
		
		if(A!=null && A.next!=null) {
		
			while(slow != null && fast != null && fast.next != null) {
				
				prev_slow = slow;
				slow = slow.next;
				fast = fast.next.next;
			}
			
			//Node midNode = null;
			
			if(fast!=null) {
				//midNode = slow;
				slow = slow.next;
			}
			
			prev_slow.next = null;
			
			Node second = reverse(slow);
			Node first = A;
			while(second!=null) {
				
				if(first.data!=second.data)
					return 0;
				
				first = first.next;
				second = second.next;
			}
		}
		return 1;
	}
	
	private static Node reverse(Node node) {
		
		Node curr = node;
		Node prev = null;
		Node next = null;
		
		while(curr!=null) {
			
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			
		}
		
		return prev;
	}
}
