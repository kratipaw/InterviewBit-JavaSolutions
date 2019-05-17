public class ReverseBetween {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.root = new LinkedListNode(1);
		list.root.next = new LinkedListNode(2);
		list.root.next.next = new LinkedListNode(3);
		list.root.next.next.next = new LinkedListNode(4);
		list.root.next.next.next.next = new LinkedListNode(5);
		
		list.printLinkedList();
		
		//reverseRange(list, 1, 2);
		
		LinkedListNode node = reverseBetween(list.root, 1, 3);
		
		printLinkedList(node);
	}
	
	
	/*private static void reverseRange(LinkedList list, int B, int C) {
		
		int len = list.length();
		
		if(B>=1 && C>=B && len>=C){
		
		int count =  0;
		
		LinkedListNode temp = list.root;
		if(B>1) {
		while(temp != null) {
			
			count++;
			
			if(count == B-1) {
				break;
			}
			
			temp = temp.next;
		}
		}
		LinkedListNode prev = null;
		LinkedListNode node = null;
		LinkedListNode start = null;
		if(B>1)
			node = temp.next;
		else {
			node = temp;
			start = temp;
		}
		LinkedListNode next = null;
		
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
	
	
	public static LinkedListNode reverseBetween(LinkedListNode A, int B, int C) {
        
        if(B == C)
            return A;
        
        LinkedListNode node = A;
        int count = 0;
        LinkedListNode start = null, startPrev = null;
        LinkedListNode end = null, endNext = null;
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
        
        LinkedListNode rev = reverse(start);

        if(flag)
            startPrev.next = rev;
        else
        	A = rev;
        
        start.next = endNext;
        
        return A;
        
    }
    
    private static LinkedListNode reverse(LinkedListNode A){
        
        LinkedListNode node = A;
        
        LinkedListNode prev = null;
        LinkedListNode next = null;
        
        while(node!=null){
            
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        return prev;
    }
    
    private static void printLinkedList(LinkedListNode node) {
    	
    	LinkedListNode element = node;
    	
    	while(element != null) {
    		System.out.print(element.data + "   ");
    		element = element.next;
    	}
    	
    	System.out.println();
    }
}
