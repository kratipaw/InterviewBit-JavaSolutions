import java.awt.List;

public class MergeTwoSortedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(5);
		list.root.next = new LinkedListNode(11);
		list.root.next.next = new LinkedListNode(20);
		
		System.out.println("list 1 : ");
		
		printList(list.root);
		
		LinkedList list2 = new LinkedList();

		list2.root = new LinkedListNode(7);
		list2.root.next = new LinkedListNode(11);
		list2.root.next.next = new LinkedListNode(15);
		list2.root.next.next.next = new LinkedListNode(57);
		
		System.out.println("list 2 : ");
		
		printList(list2.root);
		
		System.out.println("merged lists : ");
		
		LinkedListNode head = mergeTwoLists(list.root, list2.root);
		
		printList(head);
		
	}
	
	private static void printList(LinkedListNode head) {
		
		LinkedListNode element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
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
