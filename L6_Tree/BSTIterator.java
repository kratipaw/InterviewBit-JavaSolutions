import java.util.Stack;

public class BSTIterator {

	Stack<TreeNode> st = null;
	
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		
		BSTIterator bst = new BSTIterator(root);
		
		while(bst.hasNext()) {
			System.out.print(bst.next() + "  ");
		}
		
	}
	
	public BSTIterator(TreeNode node) {

		st = new Stack<TreeNode>();
		
		TreeNode curr = node;
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
        
    	TreeNode node = st.pop();
    	
    	int result = node.val;
    	
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
