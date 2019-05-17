public class SortList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(10);
		list.root.next = new LinkedListNode(5);
		list.root.next.next = new LinkedListNode(4);
		list.root.next.next.next = new LinkedListNode(3);
		
		System.out.println("original list : ");
		
		printList(list.root);
		
		LinkedListNode newHead = sortList(list.root);
		
		System.out.println("Sorted list : ");
		
		printList(newHead);
		
	}
	
	private static void printList(LinkedListNode head) {
		
		LinkedListNode element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}
	
	private static LinkedListNode sortList(LinkedListNode A) {
		
		if(A == null || A.next == null)
			return A;
		
		LinkedListNode middle = getMiddle(A);
		LinkedListNode nextToMiddle = middle.next;
		
		middle.next = null;
		
		LinkedListNode left = sortList(A);
		LinkedListNode right = sortList(nextToMiddle);
		
		LinkedListNode head = mergeTwoLists(left, right);
		
		return head;
	}
	
	private static LinkedListNode getMiddle(LinkedListNode node) {

		if(node == null)
			return null;
		
		LinkedListNode slow = node;
		LinkedListNode fast = node.next;
		
		while(fast!=null) {
			fast = fast.next;
			if(fast!=null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		return slow;
	}
	
private static LinkedListNode mergeTwoLists(LinkedListNode A, LinkedListNode B) {
		
		if(A == null)
			return B;
		
		if(B == null)
			return A;
		
		if(A.data<B.data)
			return mergeSortedLists(A, B);
		else
			return mergeSortedLists(B, A);
			
	}
	
	private static LinkedListNode mergeSortedLists(LinkedListNode list1, LinkedListNode list2) {
		
		if(list1.next == null) {
			list1.next = list2;
			return list1;
		}
		
		LinkedListNode curr1 = list1, next1 = list1.next;
		
		LinkedListNode curr2 = list2, next2 = list2;
		
		while(next1 != null && next2!=null) {
			
			if((curr2.data>=curr1.data && curr2.data<next1.data) || (curr2.data>curr1.data && curr2.data<=next1.data)) {
				
				next2 = curr2.next;
				curr1.next = curr2;
				curr2.next = next1;
				
				curr1 = curr1.next;
				curr2 = next2;
			}
			else 
			{
				if(next1.next != null)
				{
					next1 = next1.next;
					curr1 = curr1.next;
				}
				else
				{
					next1.next = curr2;
					return list1;
				}
			}
		}
		
		return list1;
	}

}
