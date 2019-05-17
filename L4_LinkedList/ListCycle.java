public class ListCycle {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(2);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = list.root;
		
		LinkedListNode res = getStartCycleNode(list.root);
		
		
		if(res == null)
			System.out.println("No Loop");
		else
			System.out.println(res.data);
	}
	
	private static LinkedListNode getStartCycleNode(LinkedListNode a) {
		
		LinkedListNode slow = a;
		
		LinkedListNode fast = a;
		
		boolean flag = false;
		
		while(slow!=null && fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			return null;
		
		slow = a;
		
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	}
	
	

}
