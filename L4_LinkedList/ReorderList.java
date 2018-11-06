package L4_LinkedList;

public class ReorderList {

	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		list.root = new Node(1);
		list.root.next = new Node(2);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = new Node(5);
		list.root.next.next.next.next.next = new Node(6);
		
		System.out.println("Original List : ");
		list.printLinkedList();
		
		Node result = reorderList(list.root);
		
		System.out.println("Rearranged List : ");
		
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
	
	private static Node reorderList(Node A) {
		
		if(A== null)
			return null;
		
		Node slow = A;
		Node fast = A;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node list1 = A;
		Node list2 = slow.next;
		
		slow.next = null; // to separate out list 1 from list 2
		
		//reverse list 2
		
		Node prev = null;
		Node next = null;
		Node curr = list2;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		list2 = prev;
		
		//Merge list 1 and list 2 alternatively
		
		Node result = new Node(0);
		curr = result;
		
		while(list1!=null || list2!=null) {
			
			if(list1!=null) {
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
			}
			
			if(list2!=null) {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			}
			
		}
		
		A = result.next;
		
		return A;
	}

}
