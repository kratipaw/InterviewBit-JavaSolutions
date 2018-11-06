package L4_LinkedList;

public class ListCycle {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.root = new Node(1);
		list.root.next = new Node(2);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = list.root;
		
		Node res = getStartCycleNode(list.root);
		
		
		if(res == null)
			System.out.println("No Loop");
		else
			System.out.println(res.data);
	}
	
	private static Node getStartCycleNode(Node a) {
		
		Node slow = a;
		
		Node fast = a;
		
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
