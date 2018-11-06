package L6_Tree;

import java.util.Stack;

public class BSTIterator {

	Stack<Node> st = null;
	
	public static void main(String[] args) {

		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.left.right = new Node(5);
		
		BSTIterator bst = new BSTIterator(root);
		
		while(bst.hasNext()) {
			System.out.print(bst.next() + "  ");
		}
		
	}
	
	public BSTIterator(Node node) {

		st = new Stack<Node>();
		
		Node curr = node;
		while(curr != null) {
			st.push(curr);
			curr = curr.left;
		}
	}

	
	/** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!st.isEmpty())
        	return true;
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        
    	Node node = st.pop();
    	
    	int result = node.data;
    	
    	if(node.right != null) {
    		node = node.right;
    		
    		while(node != null) {
    			st.push(node);
    			node = node.left;
    		}
    	}
    	
    	return result;
    }
	
}
