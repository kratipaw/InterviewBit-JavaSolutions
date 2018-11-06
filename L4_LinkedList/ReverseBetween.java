package L4_LinkedList;

public class ReverseBetween {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new Node(1);
		list.root.next = new Node(2);
		list.root.next.next = new Node(3);
		list.root.next.next.next = new Node(4);
		list.root.next.next.next.next = new Node(5);
		
		list.printLinkedList();
		
		//reverseRange(list, 1, 2);
		
		Node node = reverseBetween(list.root, 1, 3);
		
		printLinkedList(node);
	}
	
	
	/*private static void reverseRange(LinkedList list, int B, int C) {
		
		int len = list.length();
		
		if(B>=1 && C>=B && len>=C){
		
		int count =  0;
		
		Node temp = list.root;
		if(B>1) {
		while(temp != null) {
			
			count++;
			
			if(count == B-1) {
				break;
			}
			
			temp = temp.next;
		}
		}
		Node prev = null;
		Node node = null;
		Node start = null;
		if(B>1)
			node = temp.next;
		else {
			node = temp;
			start = temp;
		}
		Node next = null;
		
		while(node!=null && count<C) {
			count++;
			next = node.next;
			node.next = prev;
			prev = node;
			if(start == null)
				start = prev;
			node = next;
			
		}
		System.out.println("Prev : " + prev.data);
		System.out.println("node : " + node.data);
		System.out.println("temp : " + temp.data);
		System.out.println("start : " + start.data);
		temp.next = prev;
		start.next = node;
		}
	}*/
	
	
	public static Node reverseBetween(Node A, int B, int C) {
        
        if(B == C)
            return A;
        
        Node node = A;
        int count = 0;
        Node start = null, startPrev = null;
        Node end = null, endNext = null;
        boolean flag = true;
        if(B == 1)
            flag = false;
        
        while(node != null && count<= C){
            count ++;
            
            if(flag && count == B-1)
                startPrev = node;
            
            if(count == B)
                start = node;
                
            if(count == C)
                end = node;
            
            node = node.next;
        }
        
        endNext = end.next;
        
        end.next = null;
        
        Node rev = reverse(start);

        if(flag)
            startPrev.next = rev;
        else
        	A = rev;
        
        start.next = endNext;
        
        return A;
        
    }
    
    private static Node reverse(Node A){
        
        Node node = A;
        
        Node prev = null;
        Node next = null;
        
        while(node!=null){
            
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return prev;
    }
    
    private static void printLinkedList(Node node) {
    	
    	Node element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
}
