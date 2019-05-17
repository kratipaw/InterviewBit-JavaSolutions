public class LinkedList {

	LinkedListNode root;
	
	public LinkedList() {
		// TODO Auto-generated constructor stub
	}
	
	public void printLinkedList() {
		
		LinkedListNode element = this.root;
		
		while(element != null) {
			System.out.print(element.data + "   ");
			element = element.next;
		}
		
		System.out.println();
	}
	

public int length() {
	LinkedListNode element = root;
	int length = 0;
	while(element != null) {
		length++;
		element = element.next;
	}
	
	return length;
}
}
