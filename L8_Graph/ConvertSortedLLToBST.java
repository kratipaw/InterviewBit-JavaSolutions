package L8_Graph;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 *
 * A height balanced BST : a height-balanced binary tree is defined as a binary tree in which 
 * the depth of the two subtrees of every node never differ by more than 1. 
 *
 * Example :
 *
 *
 * Given A : 1 -> 2 -> 3
 * A height balanced BST  :
 *
 *      2
 *    /   \
 *   1     3
 * 
 */

class ListNode {
	public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}

public class ConvertSortedLLToBST {

	public static ListNode h;
	
	public static void main(String[] args) {
	
		ListNode a = new ListNode(1);
		
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		
		TreeNode root = new ConvertSortedLLToBST().sortedListToBST(a);
		
		new ConvertSortedLLToBST().printInorder(root);
	
	}
	
	public void printInorder(TreeNode root) {
		
		if(root != null) {
		
			printInorder(root.left);
			
			System.out.print(root.val + " ");
			
			printInorder(root.right);
		}
		
	}
    
	public TreeNode sortedListToBST(ListNode a) {
	    
	    int n = countNodes(a);    
        
        h = a;

        return sortedListToBSTRecur(n);
	    
	}

	public int countNodes(ListNode head){
        
        ListNode node = head;
        
        if(node == null)
            return 0;
        
        int len = 0;
        
        while(node != null){
            len++;
            node = node.next;
        }
        
        return len;
    }
    
    public TreeNode sortedListToBSTRecur(int n){
        
        if(n <= 0)
            return null;
        
        TreeNode left = sortedListToBSTRecur(n/2);
        
        TreeNode root = new TreeNode(h.val);
        
        root.left = left;
        
        h = h.next;
       
        root.right = sortedListToBSTRecur(n - n/2 - 1);
        
        return root;
    }
    
    

}


