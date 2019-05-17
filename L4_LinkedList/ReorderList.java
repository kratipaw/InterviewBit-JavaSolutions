public class ReorderList {

	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(2);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = new LinkedListNode(5);
		list.root.next.next.next.next.next = new LinkedListNode(6);
		
		System.out.println("Original List : ");
		list.printLinkedList();
		
		LinkedListNode result = reorderList(list.root);
		
		System.out.println("Rearranged List : ");
		
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
	
	private static LinkedListNode reorderList(LinkedListNode A) {
		
		if(A== null)
			return null;
		
		LinkedListNode slow = A;
		LinkedListNode fast = A;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		LinkedListNode list1 = A;
		LinkedListNode list2 = slow.next;
		
		slow.next = null; // to separate out list 1 from list 2
		
		//reverse list 2
		
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode curr = list2;
		
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		list2 = prev;
		
		//Merge list 1 and list 2 alternatively
		
		LinkedListNode result = new LinkedListNode(0);
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
