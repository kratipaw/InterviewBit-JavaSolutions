package L6_Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextRightPointers {

	public static void main(String[] args) {

		TreeLinkNode node = new TreeLinkNode(1);
		node.left = new TreeLinkNode(2);
		node.right = new TreeLinkNode(3);
		node.left.left = new TreeLinkNode(4);
		node.left.right = new TreeLinkNode(5);
		node.right.left = new TreeLinkNode(6);
		node.right.right = new TreeLinkNode(7);
		
		connect_efficient(node);
		
		//System.out.println(node.next.val);
		System.out.println(node.left.next.val);
		System.out.println(node.right.left.next.val);
		
	}

	private static void connect(TreeLinkNode root) {
    
		if(root == null)
			return;
		
		Queue<TreeLinkNode> qu = new LinkedList<TreeLinkNode>();
		
		qu.add(root);
		
		qu.add(null);
		
		while(!qu.isEmpty()){
			
			TreeLinkNode tmp = qu.poll();
			
			if(tmp != null) {

				tmp.next = qu.peek();
				
				if(tmp.left != null)
					qu.add(tmp.left);
				
				if(tmp.right != null)
					qu.add(tmp.right);
			}
			
			else if(!qu.isEmpty())
				qu.add(null);
				
		}
		
    }
	
	private static void connect_efficient(TreeLinkNode root) {
		
		if(root == null)
			return;
		
		TreeLinkNode curr = root;
		
		curr.next = null;
		
		while(curr != null) {
			
			TreeLinkNode tmp = curr;
			
			while(tmp != null) {
				
				if(tmp.left != null) {
					
					if(tmp.right != null)
						tmp.left.next = tmp.right;
					
					else
						tmp.left.next = getNextNode(tmp);
					
				}
				
				if(tmp.right != null)
					tmp.right.next = getNextNode(tmp);
				
				tmp = tmp.next;
			}	
			
			if(curr.left != null)
				curr = curr.left;
			
			else if(curr.right != null)
				curr = curr.right;
				
			else
				curr = getNextNode(curr);
		}
		
	}
	
	private static TreeLinkNode getNextNode(TreeLinkNode node) {
		
		TreeLinkNode tmp = node.next;
		
		while(tmp != null) {
			
			if(tmp.left != null)
				return tmp.left;
			
			if(tmp.right != null)
				return tmp.right;
			
			tmp = tmp.next;
				
		}
		
		return null;
		
	}
}

class TreeLinkNode {

	int val;
	
	TreeLinkNode left, right, next;
	
	TreeLinkNode(int x) { val = x; };
}