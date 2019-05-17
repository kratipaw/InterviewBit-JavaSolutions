import java.util.HashMap;
import java.util.Map;

/**
	A linked list is given such that each node contains an additional random pointer which 
	could point to any node in the list or NULL.
	
	Return a deep copy of the list.
	
	Example
	
	Given list
	
	   1 -> 2 -> 3
	with random pointers going from
	
	  1 -> 3
	  2 -> 1
	  3 -> 1
	You should return a deep copy of the list. The returned answer should not contain the 
	same node as the original list, but a copy of them. 
	The pointers in the returned list should not link to any node in the original input list.
 */

class RandomListNode {
	
    int label;
    
    RandomListNode next, random;
    
    RandomListNode(int x) {
    	this.label = x; 
    }
}

public class CopyList {

	public static void main(String[] args) {

		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head;
		
		System.out.println("Original List : ");
		new CopyList().printLL(head);
		
		System.out.println("Via HashMap : ");
		new CopyList().copyRandomList(head);
		new CopyList().printLL(head);
		
		System.out.println("tricky : ");
		new CopyList().copyRandomList_tricky(head);
		new CopyList().printLL(head);
	}
	
	public void printLL(RandomListNode head) {
		
		RandomListNode node = head;
		
		while(node != null) {
			System.out.println("Node data : " + node.label + "   Random Data : " + ((node.random != null) ? node.random.label : "null"));
			
			node = node.next;
		}
	}

	public RandomListNode copyRandomList(RandomListNode head) {
        
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode orig = head;
        
        RandomListNode curr = null;
        
        while(orig != null) {
            
            curr = new RandomListNode(orig.label);
            
            map.put(orig, curr);
            
            orig = orig.next;
        }
        
        orig = head;
        
        while(orig != null) {
            
            curr = map.get(orig);
            
            curr.next = map.get(orig.next);
            
            curr.random = map.get(orig.random);
            
            orig = orig.next;
        }
        
        RandomListNode result = map.get(head);
        
        return result;
    }
	
	//Tricky
	public RandomListNode copyRandomList_tricky(RandomListNode head) {
	    
		if(head == null)
			return null;
		
        RandomListNode orig = head;
        
        RandomListNode curr = null;
        
        while(orig != null) {
        	
        	curr = new RandomListNode(orig.label);
        	
        	curr.next = orig.next;
        	
        	orig.next = curr;
        	
        	orig = curr.next;
        }
        
        orig = head;
        
        while(orig != null) {
        	
        	if(orig.random != null) 
        		orig.next.random = orig.random.next;
        	
        	else
        		
        		orig.next.random = null;
        	
        	orig = orig.next.next;
        }
        
        orig = head;
        
        RandomListNode newList = orig.next; 
        
        RandomListNode result = orig.next;
        
        while(orig != null) {
        	
        	orig.next = orig.next.next;
        	
        	if(newList.next != null)
        		newList.next = newList.next.next;
        	
        	else
        		newList.next = null;
        	
        	orig = orig.next;
        	
        	newList = newList.next;
        	
        }
        
        return result;
    }
}
