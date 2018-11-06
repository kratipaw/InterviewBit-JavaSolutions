package L4_LinkedList;

public class SortList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		
		list.root = new Node(10);
		list.root.next = new Node(5);
		list.root.next.next = new Node(4);
		list.root.next.next.next = new Node(3);
		
		System.out.println("original list : ");
		
		printList(list.root);
		
		Node newHead = sortList(list.root);
		
		System.out.println("Sorted list : ");
		
		printList(newHead);
		
	}
	
	private static void printList(Node head) {
		
		Node element = head;
		
		while(element!=null) {
			System.out.print(element.data + " ");
			element = element.next;
		}
		
		System.out.println();
	}
	
	private static Node sortList(Node A) {
		
		if(A == null || A.next == null)
			return A;
		
		Node middle = getMiddle(A);
		Node nextToMiddle = middle.next;
		
		middle.next = null;
		
		Node left = sortList(A);
		Node right = sortList(nextToMiddle);
		
		Node head = mergeTwoLists(left, right);
		
		return head;
	}
	
	private static Node getMiddle(Node node) {

		if(node == null)
			return null;
		
		Node slow = node;
		Node fast = node.next;
		
		while(fast!=null) {
			fast = fast.next;
			if(fast!=null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		
		return slow;
	}
	
private static Node mergeTwoLists(Node A, Node B) {
		
		if(A == null)
			return B;
		
		if(B == null)
			return A;
		
		if(A.data<B.data)
			return mergeSortedLists(A, B);
		else
			return mergeSortedLists(B, A);
			
	}
	
	private static Node mergeSortedLists(Node list1, Node list2) {
		
		if(list1.next == null) {
			list1.next = list2;
			return list1;
		}
		
		Node curr1 = list1, next1 = list1.next;
		
		Node curr2 = list2, next2 = list2;
		
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
